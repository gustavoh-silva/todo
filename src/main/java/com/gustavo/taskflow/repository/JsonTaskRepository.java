package com.gustavo.taskflow.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskComum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonTaskRepository implements TaskRepositoryInterface{

    private static final String ARQUIVO = "tasks.json";
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeAdapter())
            .create();
    private List<Task> tarefas;

    public JsonTaskRepository() {
        if (Files.exists(Path.of(ARQUIVO))){
            try{
                var json = Files.readString(Path.of(ARQUIVO));
                this.tarefas = gson.fromJson(json, new TypeToken<List<TaskComum>>(){}.getType());
            }catch (JsonSyntaxException e){
                System.out.println("Arquivo corrompido");
                tarefas = new ArrayList<>();
            } catch (IOException e) {
                System.out.println("Falha ao ler arquivo");
                tarefas = new ArrayList<>();
            }
        } else{
            this.tarefas = new ArrayList<>();
        }
    }

    private void salvar() throws IOException {
        String json = gson.toJson(tarefas);
        Files.writeString(Path.of(ARQUIVO), json);
    }

    @Override
    public void addTask(Task task) {
        this.tarefas.add(task);
        try {
            salvar();
        }catch (IOException e){
            throw new RuntimeException("Erro ao salvar json", e);
        }
    }

    @Override
    public List<Task> getAll() {
        return Collections.unmodifiableList(tarefas);
    }

    @Override
    public Task findById(long id) {
        for (Task task : this.tarefas){
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }

    @Override
    public void save() {
        try {
            salvar();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar json", e);
        }
    }

    @Override
    public boolean remove(long id) {
        for (Task task : this.tarefas){
            if (task.getId() == id){
                var deletada = this.tarefas.remove(task);
                try{
                    salvar();
                    return deletada;
                }catch (IOException e){
                    throw new RuntimeException("Erro ao salvar json", e);
                }
            }
        }
        return false;
    }

    private static class OffsetDateTimeAdapter
            implements JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        @Override
        public JsonElement serialize(OffsetDateTime src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(FORMATTER.format(src));
        }

        @Override
        public OffsetDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return OffsetDateTime.parse(json.getAsString(), FORMATTER);
        }
    }
}
