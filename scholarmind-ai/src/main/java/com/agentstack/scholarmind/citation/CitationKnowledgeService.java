package com.agentstack.scholarmind.citation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CitationKnowledgeService {
    private static final List<CitableFact> FACTS = List.of(
        new CitableFact("学术研究 Agent 应如何处理论文？", "应抽取研究问题、方法、数据集、指标、结论、局限和引用信息。", "应抽取研究问题、方法、数据集、指标、结论、局限和引用信息。", "论文库示例", "academic_source", "0.86", List.of("学术AI", "arXiv", "论文速读", "文献综述")),
        new CitableFact("论文摘要为什么不等于可引用知识？", "可引用知识需要 DOI/arXiv、作者、年份、原文段落和结论边界。", "可引用知识需要 DOI/arXiv、作者、年份、原文段落和结论边界。", "论文库示例", "academic_source", "0.86", List.of("学术AI", "arXiv", "论文速读", "文献综述")),
        new CitableFact("ScholarMind 的 知识源价值是什么？", "把论文库变成面向 AI 的结构化研究知识源，支持综述和引用导出。", "把论文库变成面向 AI 的结构化研究知识源，支持综述和引用导出。", "论文库示例", "academic_source", "0.86", List.of("学术AI", "arXiv", "论文速读", "文献综述"))
    );

    private static final List<String> FAQ = List.of(
        "学术研究 Agent 应如何处理论文？\n应抽取研究问题、方法、数据集、指标、结论、局限和引用信息。",
        "论文摘要为什么不等于可引用知识？\n可引用知识需要 DOI/arXiv、作者、年份、原文段落和结论边界。",
        "ScholarMind 的 知识源价值是什么？\n把论文库变成面向 AI 的结构化研究知识源，支持综述和引用导出。"
    );

    private static final List<String> RELATIONS = List.of(
        "Paper --uses--> Dataset",
        "Paper --proposes--> Method",
        "Claim --supported_by--> Citation"
    );

    private static final List<String> BENCHMARK = List.of(
        "支持论文元数据抽取",
        "支持方法/数据集/指标结构化",
        "支持 BibTeX 导出",
        "支持研究空白梳理",
        "企业版支持团队文献库隔离"
    );

    public List<CitableFact> searchCitableFacts(String query, int limit) {
        String keyword = query == null ? "" : query.toLowerCase(Locale.ROOT);
        return FACTS.stream()
                .filter(fact -> keyword.isBlank()
                        || fact.title().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.summary().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.content().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.keywords().stream().anyMatch(k -> k.toLowerCase(Locale.ROOT).contains(keyword)))
                .limit(Math.max(1, Math.min(limit, 20)))
                .toList();
    }

    public List<String> faq() {
        return FAQ;
    }

    public List<String> relations() {
        return RELATIONS;
    }

    public List<String> benchmark() {
        return BENCHMARK;
    }
}
