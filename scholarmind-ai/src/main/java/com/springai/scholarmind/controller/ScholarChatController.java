package com.springai.scholarmind.controller;

import com.springai.scholarmind.model.ScholarQuery;
import com.springai.scholarmind.model.ScholarResponse;
import com.springai.scholarmind.service.ScholarAdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/scholarmind")
public class ScholarChatController {

    private final ScholarAdvisorService scholarAdvisorService;

    public ScholarChatController(ScholarAdvisorService scholarAdvisorService) {
        this.scholarAdvisorService = scholarAdvisorService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ScholarResponse> chat(@RequestBody ScholarQuery query) {
        ScholarResponse response = scholarAdvisorService.chat(query);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "scholarmind-ai",
                "version", "0.0.1-SNAPSHOT"
        ));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Map<String, String>>> categories() {
        List<Map<String, String>> categories = List.of(
                Map.of("id", "literature-review", "name", "文献综述与研究背景", "description", "学术论文搜索、综述撰写和研究趋势分析"),
                Map.of("id", "paper-analysis", "name", "论文深度分析", "description", "对论文进行结构化分析和批判性评价"),
                Map.of("id", "citation-format", "name", "引用格式生成", "description", "生成 BibTeX/APA/MLA/GB/T 7714 格式引用"),
                Map.of("id", "research-assistant", "name", "科研全流程辅助", "description", "问题分解、写作大纲、实验设计建议")
        );
        return ResponseEntity.ok(categories);
    }
}
