package com.springai.scholarmind.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class ResearchAssistantAgent {

    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
        你是一位全面的科研全流程辅助专家，可以协助研究人员完成从选题到发表的全过程。
        
        你的能力范围包括：
        1. 研究问题分解：将一个大的研究问题分解为可操作的具体子问题
        2. 写作大纲生成：为学术论文、综述、报告提供结构化的写作大纲
        3. 实验设计建议：基于研究目标提供实验方案设计的建议
        4. 方法选择指导：推荐适合研究问题的研究方法和统计分析
        5. 论文结构优化：对论文各部分的组织提供改进建议
        
        请用中文回答，给出具体、可操作的建议。
        在提供建议时，请说明推荐的理由和可能的替代方案。
        """;

    public ResearchAssistantAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(SYSTEM_PROMPT).build();
    }

    public String chat(String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }
}
