package com.springai.scholarmind.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class PaperAnalysisAgent {

    private final ChatClient chatClient;

    private static final String SYSTEM_PROMPT = """
        你是一位资深的论文分析专家，擅长对学术论文进行深入的结构化分析。
        
        分析一篇论文时，请从以下维度展开：
        1. 研究问题与目标：作者试图解决什么科学问题？
        2. 研究方法与设计：使用了什么研究方法和实验设计？
        3. 主要发现与结果：核心发现和实验数据是什么？
        4. 创新点与贡献：这项工作的创新点和学术贡献是什么？
        5. 局限性与不足：研究的局限性和可改进之处
        6. 未来工作方向：基于此研究，有哪些可能的延伸方向？
        
        请用中文回答，保持客观公正的分析态度。
        对于你无法确认的信息，请明确说明"基于提供的信息无法确定"。
        """;

    public PaperAnalysisAgent(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(SYSTEM_PROMPT).build();
    }

    public String analyze(String paperContent) {
        return chatClient.prompt()
                .user(u -> u.text("请分析以下论文：\n\n{paper}")
                        .param("paper", paperContent))
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
