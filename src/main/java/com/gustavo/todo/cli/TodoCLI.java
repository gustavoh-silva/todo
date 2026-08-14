package com.gustavo.todo.cli;

import com.gustavo.todo.model.Priority;
import com.gustavo.todo.model.Task;
import com.gustavo.todo.patterns.chain.PrioridadeValidator;
import com.gustavo.todo.patterns.chain.TamanhoValidator;
import com.gustavo.todo.patterns.chain.TituloValidator;
import com.gustavo.todo.patterns.factory.TaskComumFactory;
import com.gustavo.todo.patterns.strategy.AltaPrioridadeFilter;
import com.gustavo.todo.patterns.strategy.PendentesFilter;
import com.gustavo.todo.repository.JsonTaskRepository;

import java.util.List;
import java.util.Scanner;

public class TodoCLI {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        var repository = new JsonTaskRepository();
        var chain = new TituloValidator().setProximo(new PrioridadeValidator().setProximo(new TamanhoValidator()));
        var factory = new TaskComumFactory();

        String escolha;
        while (true){
            escolha = scanner.next();
            scanner.nextLine(); // limpa o \n sobrado do next()

            switch (escolha){
                case "help" -> {
                    System.out.println("Comandos: add, list, done, remove, exit");
                }
                case "add" -> {

                    System.out.println("Digite o titulo");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o id");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // limpa o \n sobrado do nextLong()

                    System.out.println("Digite a prioridade");
                    Priority prioridade = Priority.valueOf(scanner.next());
                    scanner.nextLine(); // limpa o \n sobrado do next()

                    Task task = factory.createTask(titulo, id, prioridade);
                    chain.validar(task);
                    repository.addTask(task);
                }
                case "list" -> {
                    System.out.println("Deseja aplicar algum filtro? (y/N)");
                    String aplicar = scanner.nextLine();

                    if (aplicar.equals("y")){
                        System.out.println("Filtros disponiveis: Pendentes, Alta Prioridade");
                        String filtro = scanner.nextLine();

                        if (filtro.equalsIgnoreCase("pendentes")){
                            imprimirTasks(new PendentesFilter().filtrar(repository.getAll()));
                        } else if (filtro.equalsIgnoreCase("alta prioridade")){
                            imprimirTasks(new AltaPrioridadeFilter().filtrar(repository.getAll()));
                        }
                    } else{
                        imprimirTasks(repository.getAll());
                    }
                }
                case "done" -> {
                    System.out.println("Digite o ID da Task: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // limpa o \n sobrado do nextLong()

                    Task task = repository.findById(id);
                    if (task != null && !task.isConcluida()){
                        task.marcarConcluida();
                        repository.save();
                        System.out.println("Task marcada como concluída!");
                    } else {
                        System.out.println("Task não encontrada.");
                    }
                }
                case "remove" -> {
                    System.out.println("Digite o ID da Task: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // limpa o \n sobrado do nextLong()

                    System.out.println("Task removida: " + repository.remove(id));
                }
                case "exit" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Comando não reconhecido. Digite 'help' para ver os comandos.");
                }
            }

        }
    }

    private static void imprimirTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma task encontrada.");
            return;
        }
        for (Task t : tasks) {
            String status = t.isConcluida() ? "✓" : "○";
            System.out.println(status + " [" + t.getId() + "] " + t.getTitulo()
                    + " — " + t.getPrioridade()
                    + " (criada em " + t.getDataCriacao() + ")");
        }
    }
}
