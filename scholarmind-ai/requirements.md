# Scholarmind AI — 需求规格说明书

## 1. 项目概述

学术研究智能助手（Scholarmind AI）是基于 Spring AI 框架构建的智能体系统，旨在辅助研究人员和学生完成学术研究中的常见任务，包括文献调研、论文分析、引用管理和科研规划。

## 2. 核心功能需求

### 2.1 文献综述助手 (LiteratureReviewAgent)
- **功能**: 通过 arXiv API 搜索学术论文，结合 PGVector 向量存储进行 RAG 检索
- **输入**: 研究主题、关键词、时间范围
- **输出**: 文献综述报告、研究背景分析
- **依赖**: arXiv API、Ollama 本地模型、PGVector 向量数据库

### 2.2 论文分析助手 (PaperAnalysisAgent)
- **功能**: 对论文进行结构化分析，提取研究问题、方法、发现和局限
- **输入**: 论文文本或摘要
- **输出**: 结构化分析报告

### 2.3 引用格式助手 (CitationFormatAgent)
- **功能**: 生成 BibTeX、APA、MLA、GB/T 7714 等多种引用格式
- **输入**: 论文信息（标题、作者、期刊、年份等）
- **输出**: 格式化引用文本

### 2.4 科研全流程助手 (ResearchAssistantAgent)
- **功能**: 问题分解、写作大纲生成、实验设计建议
- **输入**: 研究问题或需求描述
- **输出**: 结构化科研建议

## 3. 技术架构

- **框架**: Spring Boot 3.4.4 + Spring AI 1.0.4
- **AI 推理**: Ollama 本地模型（DeepSeek-R1 7B）
- **向量存储**: PostgreSQL + PGVector
- **缓存**: Redis 7
- **基础设施**: Docker Compose

## 4. API 接口

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/scholarmind/chat | 主聊天接口 |
| GET | /api/scholarmind/health | 健康检查 |
| GET | /api/scholarmind/categories | 获取功能类别列表 |
