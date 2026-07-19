package com.springai.scholarmind.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaperSummaryTool {

    private static final Logger log = LoggerFactory.getLogger(PaperSummaryTool.class);

    public String summarize(String paperContent) {
        if (paperContent == null || paperContent.isBlank()) {
            return "无法总结：论文内容为空。";
        }

        String truncated = paperContent.length() > 8000
                ? paperContent.substring(0, 8000) + "\n[...内容已截断, 完整内容过长]"
                : paperContent;

        log.info("Paper summarization requested: inputLength={}", paperContent.length());
        return truncated;
    }

    public String extractAbstract(String paperContent) {
        String[] sections = paperContent.split("(?i)(abstract|摘要|关键词|introduction|引言)");
        if (sections.length > 1) {
            return sections[1].length() > 500
                    ? sections[1].substring(0, 500) + "..."
                    : sections[1];
        }
        return paperContent.length() > 500 ? paperContent.substring(0, 500) + "..." : paperContent;
    }
}
