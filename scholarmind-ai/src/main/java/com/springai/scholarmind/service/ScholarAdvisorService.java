package com.springai.scholarmind.service;

import com.springai.scholarmind.agent.*;
import com.springai.scholarmind.model.ScholarQuery;
import com.springai.scholarmind.model.ScholarResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScholarAdvisorService {

    private static final Logger log = LoggerFactory.getLogger(ScholarAdvisorService.class);

    private final LiteratureReviewAgent literatureReviewAgent;
    private final PaperAnalysisAgent paperAnalysisAgent;
    private final CitationFormatAgent citationFormatAgent;
    private final ResearchAssistantAgent researchAssistantAgent;

    public ScholarAdvisorService(LiteratureReviewAgent literatureReviewAgent,
                                  PaperAnalysisAgent paperAnalysisAgent,
                                  CitationFormatAgent citationFormatAgent,
                                  ResearchAssistantAgent researchAssistantAgent) {
        this.literatureReviewAgent = literatureReviewAgent;
        this.paperAnalysisAgent = paperAnalysisAgent;
        this.citationFormatAgent = citationFormatAgent;
        this.researchAssistantAgent = researchAssistantAgent;
    }

    public ScholarResponse chat(ScholarQuery query) {
        String message = query.getMessage();
        String category = query.getCategory() != null ? query.getCategory() : "";

        if (message == null || message.isBlank()) {
            return ScholarResponse.error("消息内容不能为空");
        }

        try {
            String responseContent;
            switch (category) {
                case "literature-review":
                    log.info("Routing to LiteratureReviewAgent: category={}", category);
                    responseContent = literatureReviewAgent.chat(message);
                    break;
                case "paper-analysis":
                    log.info("Routing to PaperAnalysisAgent: category={}", category);
                    if (query.getPaperContent() != null && !query.getPaperContent().isBlank()) {
                        responseContent = paperAnalysisAgent.analyze(query.getPaperContent());
                    } else {
                        responseContent = paperAnalysisAgent.chat(message);
                    }
                    break;
                case "citation-format":
                    log.info("Routing to CitationFormatAgent: category={}", category);
                    if (query.getFormat() != null && !query.getFormat().isBlank()) {
                        responseContent = citationFormatAgent.formatCitation(message, query.getFormat());
                    } else {
                        responseContent = citationFormatAgent.chat(message);
                    }
                    break;
                case "research-assistant":
                    log.info("Routing to ResearchAssistantAgent: category={}", category);
                    responseContent = researchAssistantAgent.chat(message);
                    break;
                default:
                    log.info("Default routing to ResearchAssistantAgent: category={}", category);
                    responseContent = researchAssistantAgent.chat(message);
                    break;
            }
            return new ScholarResponse(responseContent, category);
        } catch (Exception e) {
            log.error("Error processing chat request", e);
            return ScholarResponse.error("处理请求时发生错误: " + e.getMessage());
        }
    }
}
