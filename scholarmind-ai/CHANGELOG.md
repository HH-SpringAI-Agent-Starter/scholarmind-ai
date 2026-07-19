# Changelog

## [0.0.1] — 2026-07-19

### Added
- Initial project scaffold with Spring Boot 3.4.4 + Spring AI 1.0.4
- **LiteratureReviewAgent**: arXiv paper search with RAG retrieval
- **PaperAnalysisAgent**: Structured paper analysis pipeline
- **CitationFormatAgent**: Multi-format citation generation (BibTeX, APA, MLA, GB/T 7714)
- **ResearchAssistantAgent**: Question decomposition and research planning
- RESTful API with 3 endpoints (chat, health, categories)
- PostgreSQL + PGVector vector store configuration
- Redis caching integration
- Docker Compose infrastructure (PGVector pg17 + Redis 7)
- Ollama integration for local LLM inference
- Maven build with all dependencies
- Chinese system prompts for all agents
