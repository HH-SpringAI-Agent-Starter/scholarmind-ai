# ScholarMind AI Community

        论文速读与文献综述 Agent：基于 **Spring AI 2.0 + Agent Tool Calling + PGVector RAG + Ollama** 的学术研究助手项目模板。


        ## 场景定位

        接入 arXiv、论文 PDF、BibTeX 和团队文献库，实现论文速读、文献综述、研究空白梳理和引用格式输出。

        ## 版本定位：开源版


- 单租户或轻量租户 Header 演示
- 本地 Ollama 模型，适合开发和 Demo
- 基础 RAG 知识库、基础工具调用、REST API
- Apache-2.0 友好的开源项目结构
- 可作为 Open Core 的免费获客漏斗

        ## 核心能力

        - Spring AI `ChatClient` Agent 编排
        - `@Tool` 工具调用
        - PGVector 私有知识库 RAG
        - Ollama 本地模型默认配置
        - Docker Compose 一键启动基础设施
        - Flyway 数据库初始化
        - Prometheus / Actuator 可观测性

        ## 工具清单

        - `arxiv_search`
- `paper_pdf_parse`
- `paper_summary`
- `citation_export`
- `literature_gap_map`
- `methodology_check`

        ## 连接器方向

        - arXiv API
- Crossref/Semantic Scholar
- Zotero/BibTeX
- OSS/PDF 文献库

        ## API

        | Method | Path | Description |
        |---|---|---|
        | POST | `/api/agent/ask` | 学术问答和综述辅助 |
| POST | `/api/papers/search` | 论文检索 |
| POST | `/api/reviews/draft` | 生成文献综述草稿 |
        | POST | `/api/kb/sync` | 同步知识库 |
        | GET | `/api/kb/search?q=` | 检索知识库 |

        ## 本地运行

        ```bash
        cp .env.example .env
        docker compose up -d
        ollama pull qwen2.5:7b
        ollama pull mxbai-embed-large
        mvn spring-boot:run
        ```

        ## 示例调用

        ```bash
        curl -s -X POST http://localhost:8080/api/agent/ask \
          -H 'Content-Type: application/json' \
          -H 'X-Tenant-Id: demo' \
          -d '{
            "question": "帮我找最近两年关于 RAG 评测的论文，并总结常用指标和研究空白。",
            "userId": "u_1001",
            "sessionId": "s_demo"
          }' | jq
        ```

        ## 目录结构

        ```text
        src/main/java/.../agent        Agent 编排
        src/main/java/.../tools        工具调用
        src/main/java/.../rag          RAG 服务
        src/main/java/.../tenant       多租户上下文
        src/main/resources/kb          示例知识库
        src/main/resources/db          Flyway 初始化 SQL
        docs/                          架构、API、部署、定价、演示脚本
        ```

        ## GitHub 上传

        ```bash
        git init
        git add .
        git commit -m "Initial commit: ScholarMind AI Community"
        gh repo create scholarmind-ai --public --source=. --remote=origin --push
        ```
