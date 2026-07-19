# Scholarmind AI 🤖📚

**Academic Research Intelligent Assistant** — 学术研究智能助手

An intelligent assistant powered by Spring AI, designed to help researchers and students with academic literature review, paper analysis, citation formatting, and research planning.

## Features

| Agent | Purpose |
|-------|---------|
| 🔍 **LiteratureReviewAgent** | Academic paper search via arXiv API + PGVector RAG |
| 📄 **PaperAnalysisAgent** | Structured paper analysis (research question, method, findings, limitations) |
| 📝 **CitationFormatAgent** | Generate BibTeX/APA/MLA/GB/T 7714 citations |
| 🧠 **ResearchAssistantAgent** | Question decomposition, writing outline, experiment design |

## Tech Stack

- **Spring Boot 3.4.4** — Application framework
- **Spring AI 1.0.4** — AI/LLM integration
- **Ollama** — Local LLM inference (DeepSeek/Qwen)
- **PGVector** — Vector storage for RAG
- **Redis 7** — Caching and session management
- **Docker Compose** — One-command infrastructure

## Quick Start

```bash
# 1. Start infrastructure
docker compose up -d

# 2. Run the application
make run
```

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/scholarmind/chat` | Main chat with research assistant |
| GET | `/api/scholarmind/health` | Health check |
| GET | `/api/scholarmind/categories` | List available agent categories |

## License

[MIT](LICENSE)
