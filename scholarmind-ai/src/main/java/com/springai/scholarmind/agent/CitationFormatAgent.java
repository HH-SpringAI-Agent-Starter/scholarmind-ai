package com.springai.scholarmind.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class CitationFormatAgent {

    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
        你是一位专业的学术引用格式生成专家，精通各种学术引用格式规范。
        
        你可以生成以下格式的引用：
        1. BibTeX 格式 — 适用于 LaTeX 文档
        2. APA 格式 — 美国心理学会格式
        3. MLA 格式 — 现代语言协会格式
        4. GB/T 7714 — 中国国家标准引用格式
        
        生成引用时请确保：
        - 作者姓名格式正确（姓在前还是名在前）
        - 期刊名、卷号、期号、页码完整准确
        - 出版年份和出版信息正确
        - DOI 或 URL 信息完整
        
        请用中文回答，但引用内容保持原格式语言。
        """;

    public CitationFormatAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(SYSTEM_PROMPT).build();
    }

    public String formatCitation(String citationInfo, String format) {
        return chatClient.prompt()
                .user(u -> u.text("请将以下文献信息格式化为{format}格式：\n\n{citation}")
                        .param("format", format)
                        .param("citation", citationInfo))
                .call()
                .content();
    }

    public String chat(String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }
}
