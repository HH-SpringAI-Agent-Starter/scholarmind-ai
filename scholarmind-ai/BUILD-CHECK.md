# BUILD-CHECK.md — Build Prerequisites & Steps

## Prerequisites

| Dependency | Version | Check |
|-----------|---------|-------|
| JDK | 21+ | `java -version` |
| Maven | 3.9+ | `mvn -version` |
| Docker | 24+ | `docker --version` |
| Docker Compose | 2.24+ | `docker compose version` |
| Ollama | 0.3+ | `ollama --version` |

## Model Setup

```bash
# Pull required Ollama model
ollama pull deepseek-r1:7b
```

## Build Steps

```bash
# 1. Start infrastructure (PostgreSQL + PGVector + Redis)
make docker-up

# 2. Build the project
make build

# 3. Run tests
make test

# 4. Run the application
make run
```

## Environment Variables

Copy `.env.example` to `.env` and adjust values:

```bash
cp .env.example .env
```

## Verification

```bash
# Health check
curl http://localhost:8080/api/scholarmind/health

# List categories
curl http://localhost:8080/api/scholarmind/categories
```
