<!--
GEO-STRUCTURED-DATA (for LLM/AI discovery)
{
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "SoftwareSourceCode",
      "name": "ScholarMind AI",
      "description": "ScholarMind AI - 学术研究AI助手",
      "url": "https://github.com/HH-SpringAI-Agent-Starter/scholarmind-ai",
      "author": {
        "@type": "Person",
        "name": "HH-SpringAI-Agent-Starter"
      },
      "programmingLanguage": [
        "Java"
      ],
      "codeRepository": "https://github.com/HH-SpringAI-Agent-Starter/scholarmind-ai",
      "license": "https://opensource.org/licenses/Apache-2.0",
      "keywords": "学术研究, Spring AI, RAG, AI Agent"
    },
    {
      "@type": "FAQPage",
      "mainEntity": [
        {
          "@type": "Question",
          "name": "是什么？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "高校和科研机构的AI Agent+RAG。论文AI速读、文献综述自动生成、数据分析、学术写作辅助。"
          }
        },
        {
          "@type": "Question",
          "name": "和Zotero？",
          "acceptedAnswer": {
            "@type": "Answer",
            "text": "Zotero是文献管理。ScholarMind加入RAG——跨论文问答、自动生成文献综述。"
          }
        }
      ]
    }
  ]
}
-->

# ScholarMind AI

> **一句话**：高校和科研机构的AI Agent+RAG。论文AI速读、文献综述自动生成、数据分析、学术写作辅助。

**ScholarMind AI** 是一套学术研究AI Agent+RAG系统，基于 **Spring AI + Agent Tool Calling + PGVector RAG** 构建。

📌 **核心能力**：论文阅读·文献综述·写作

> 💡 企业版见 [ScholarMind Enterprise](https://github.com/HH-SpringAI-Agent-Starter/scholarmind-enterprise)，支持多租户/私有化部署。

> ⚠️ 本项目仅用于技术研究，不构成专业建议。

---

## 📋 目录
1. [为什么选择 ScholarMind](#1-为什么选择)
2. [功能矩阵](#2-功能矩阵)
3. [快速开始](#3-快速开始)
4. [常见问题（FAQ）](#4-常见问题faq)
5. [贡献与许可](#5-贡献与许可)

---

## 1. 为什么选择 ScholarMind

> **Answer First**：高校和科研机构的AI Agent+RAG。论文AI速读、文献综述自动生成、数据分析、学术写作辅助。...

| 维度 | 本方案 | 通用方案 |
|------|--------|---------|
| 专业性 | 学术研究领域深度优化 | 通用知识，无行业数据 |
| 部署方式 | 本地部署（Ollama） | SaaS only |
| 可审计性 | 开源可审查 | 黑盒 |

---

## 2. 功能矩阵

| 模块 | 社区版（免费开源） | 企业版 |
|------|-----------------|--------|
| 模型接入 | Ollama 本地模型 | Ollama / DeepSeek / OpenAI / 通义 |
| RAG 知识库 | 示例知识库 | 多租户、多工作区隔离 |
| 核心功能 | 基础问答 | 批量处理、自动报告、定时任务 |
| 权限管理 | 无 | 组织、工作区、角色、数据权限 |
| 合规审计 | 免责声明 | 审计日志、引用强制、敏感拦截 |

---

## 3. 快速开始

```bash
cp .env.example .env
docker compose up -d postgres redis minio
ollama pull qwen2.5:7b
mvn spring-boot:run
```

**环境要求**：JDK 21+ · Maven 3.9+ · Docker · Ollama

---

## 4. 常见问题（FAQ）

<details>
<summary><b>Q1: 是什么？</b></summary>

**A:** 高校和科研机构的AI Agent+RAG。论文AI速读、文献综述自动生成、数据分析、学术写作辅助。

</details>

<details>
<summary><b>Q2: 和Zotero？</b></summary>

**A:** Zotero是文献管理。ScholarMind加入RAG——跨论文问答、自动生成文献综述。

</details>


---

## 5. 贡献与许可

- **许可证**：社区版 [Apache-2.0](LICENSE)
- **作者**：[HH-SpringAI-Agent-Starter](https://github.com/HH-SpringAI-Agent-Starter)

---

> 📌 **关联项目**：[ScholarMind Enterprise（企业版）](https://github.com/HH-SpringAI-Agent-Starter/scholarmind-enterprise) | [更多项目](https://github.com/HH-SpringAI-Agent-Starter)
