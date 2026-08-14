# ToDo ☑️

Sistema de gerenciamento de tarefas em **Java puro** (CLI) aplicando **5 Design Patterns clássicos (GoF)**. Projeto do desafio *"Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework"* do **Bootcamp Santander 2026 — AI Java Back-end (DIO)**.

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Gradle](https://img.shields.io/badge/Gradle-9.5.1-02303A.svg)
![Status](https://img.shields.io/badge/Fase%201-CLI%20funcional-brightgreen)

## 📌 Sumário

- [Sobre](#-sobre)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Design Patterns aplicados](#-design-patterns-aplicados)
- [Como rodar](#-como-rodar)
- [Exemplos de uso](#-exemplos-de-uso)
- [Créditos](#-créditos)

## 📖 Sobre

O ToDo é um to-do list de terminal que aplica 5 Design Patterns clássicos (GoF) na prática:

- **Singleton** — acesso global a fonte de dados
- **Strategy** — múltiplos critérios de filtrar tarefas
- **Chain of Responsibility** — validação de tarefa em cadeia
- **Factory Method** — criar tarefas sem acoplar `new`
- **Repository** — abstração de persistência (JSON)

Cada pattern mora no seu próprio package, separado e identificável.

## 📂 Estrutura do projeto

```
src/main/java/com/gustavo/todo/
├── app/                    # ponto de entrada (Main)
├── cli/                    # interface de linha de comando (TodoCLI)
├── model/                  # entidades de domínio
│   ├── Task.java           # classe abstrata (produto do Factory)
│   ├── TaskComum.java      # implementação concreta
│   ├── Priority.java       # enum (ALTA, MEDIA, BAIXA)
│   └── TaskInvalidaException.java
├── patterns/
│   ├── singleton/          # TaskRepository — instância única (eager)
│   ├── strategy/           # TaskFilter + PendentesFilter + AltaPrioridadeFilter
│   ├── chain/              # TaskValidator + 3 validadores
│   └── factory/            # TaskFactory + TaskComumFactory
└── repository/             # TaskRepositoryInterface + JsonTaskRepository
```

## 🧩 Design Patterns aplicados

| Pattern | Tipo | Onde neste projeto | Equivalente no Spring (Fase 2) |
|---|---|---|---|
| Singleton | Criacional | `TaskRepository` — uma única instância de acesso aos dados | `@Service` / `@Component` (bean singleton por padrão) |
| Strategy | Comportamental | `TaskFilter` — filtrar por status, prioridade, etc. | `@Autowired` numa interface com múltiplas implementações |
| Chain of Responsibility | Comportamental | Validação de tarefa (título, prioridade) antes de salvar | `@Component`s registrados no contexto |
| Factory Method | Criacional | `TaskFactory` — criar tarefas de tipos diferentes | Métodos `@Bean` em `@Configuration` |
| Repository | Estrutural | `TaskRepositoryInterface` abstraindo persistência em JSON | `@Repository` + Spring Data JPA |

## 🚀 Como rodar

Pré-requisitos: **JDK 21+** e **Gradle** (ou usar o wrapper incluído).

```bash
./gradlew run
```

As tarefas persistem em `tasks.json` na raiz do projeto — sobrevivem entre execuções.

## 💻 Exemplos de uso

```
> add
Digite o titulo: Estudar Java
Digite o id: 1
Digite a prioridade: ALTA

> list
Deseja aplicar algum filtro? (y/N): N
○ [1] Estudar Java — ALTA (criada em 2026-08-14T17:30:12-03:00)

> done
Digite o ID da Task: 1
Task marcada como concluída!

> list
Deseja aplicar algum filtro? (y/N): y
Filtros disponiveis: Pendentes, Alta Prioridade
Pendentes
Nenhuma task encontrada.

> remove
Digite o ID da Task: 1
Task removida: true

> exit
```

Comandos disponíveis: `add`, `list`, `done`, `remove`, `help`, `exit`.

## 🤝 Créditos

**Autor:** [Gustavo Silva](https://github.com/gustavoh-silva)

Projeto educativo para o Bootcamp Santander 2026 — AI Java Back-end (DIO).

Este projeto foi desenvolvido com o auxílio de Inteligência Artificial ([Hermes Agent](https://hermes-agent.nousresearch.com), by Nous Research), atuando como pair programming partner no papel de Tech Lead. A IA guiou o planejamento, apontou bugs e fez code review — mas **todo o código foi escrito pelo autor**, inclusive a decisão de design sobre onde e quando aplicar cada pattern.
