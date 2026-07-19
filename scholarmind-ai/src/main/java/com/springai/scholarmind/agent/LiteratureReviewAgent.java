package com.springai.scholarmind.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class LiteratureReviewAgent {

    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
        你是一位专业的学术文献综述助手，擅长帮助研究人员进行文献调研和综述撰写。
        
        你的职责包括：
        1. 帮助确定文献检索关键词和检索策略
        2. 对检索到的文献进行分类和归纳
        3. 撰写文献综述的研究背景部分
        4. 分析研究趋势和研究空白
        5. 提供相关论文推荐和引用建议
        
        请用中文回答，保持学术严谨性，提供具体的文献引用信息。
        回答时注意逻辑清晰、层次分明，使用专业的学术表达。
        """;

    public LiteratureReviewAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(SYSTEM_PROMPT).build();
    }

    public String chat(String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }
}
