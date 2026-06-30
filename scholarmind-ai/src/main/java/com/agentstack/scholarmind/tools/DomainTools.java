package com.agentstack.scholarmind.tools;

import com.agentstack.scholarmind.rag.KnowledgeBaseService;
import com.agentstack.scholarmind.tenant.TenantContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class DomainTools {
    private final KnowledgeBaseService knowledgeBaseService;

    public DomainTools(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @Tool(description = "Search tenant scoped private knowledge base")
    public String knowledge_search(@ToolParam(description = "search query") String query) {
        return String.join("\n", knowledgeBaseService.search(query));
    }

    @Tool(description = "arxiv search for 学术研究助手")
    public String arxiv_search(@ToolParam(description = "business query") String query) {
        return "[arxiv_search] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "paper pdf parse for 学术研究助手")
    public String paper_pdf_parse(@ToolParam(description = "business query") String query) {
        return "[paper_pdf_parse] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "paper summary for 学术研究助手")
    public String paper_summary(@ToolParam(description = "business query") String query) {
        return "[paper_summary] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "citation export for 学术研究助手")
    public String citation_export(@ToolParam(description = "business query") String query) {
        return "[citation_export] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "literature gap map for 学术研究助手")
    public String literature_gap_map(@ToolParam(description = "business query") String query) {
        return "[literature_gap_map] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "methodology check for 学术研究助手")
    public String methodology_check(@ToolParam(description = "business query") String query) {
        return "[methodology_check] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

}
