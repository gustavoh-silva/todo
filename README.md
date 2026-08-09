# TaskFlow

Sistema de gerenciamento de tarefas desenvolvido como projeto do **Bootcamp Santander 2026 — AI Java Back-end (DIO)**, para o desafio **"Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework"**.

## Objetivo

Aplicar na prática 5 Design Patterns clássicos (GoF) em Java, começando em **Java Puro** (CLI) e migrando para **Spring Boot** (API REST), no mesmo repositório. Assim é possível ver cada padrão "cru" e depois ver como o Spring Framework os embrulha com anotações.

## Estrutura do projeto

```
src/main/java/com/gustavo/taskflow/
├── app/                # ponto de entrada (Main)
├── model/              # entidades de domínio (Task, Priority, etc.)
├── patterns/
│   ├── singleton/      # acesso global a fonte de dados
│   ├── strategy/       # estratégias de filtro/ordenação
│   ├── chain/          # validação em cadeia
│   └── factory/        # criação de tarefas
├── repository/         # abstração de persistência
└── cli/                # interface de linha de comando
```

## Design Patterns aplicados

| Pattern | Tipo | Onde neste projeto | Equivalente no Spring (Fase 2) |
|---|---|---|---|
| Singleton | Criacional | `TaskRepository` — uma única instância de acesso aos dados | `@Service` / `@Component` (bean singleton por padrão) |
| Strategy | Comportamental | `TaskFilter` — filtrar por status, prioridade, etc. | `@Autowired` numa interface com múltiplas implementações |
| Chain of Responsibility | Comportamental | Validação de tarefa (título, prioridade) antes de salvar | `@Component`s registrados no contexto |
| Factory Method | Criacional | `TaskFactory` — criar tarefas de tipos diferentes | Métodos `@Bean` em `@Configuration` |
| Repository | Estrutural | `Repository<T>` abstraindo persistência | `@Repository` + Spring Data JPA |

## Como rodar (Fase 1 — Java Puro)

```bash
./gradlew run
```

## Autor

Gustavo — Projeto educativo para o Bootcamp DIO 2026.
