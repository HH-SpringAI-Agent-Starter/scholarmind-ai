package com.springai.scholarmind.rag;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperRagService {

    private final VectorStore vectorStore;

    public PaperRagService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void storePaper(String paperId, String title, String abstractText, String content) {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("paper_id", paperId);
        metadata.put("title", title);
        metadata.put("type", "academic_paper");

        Document document = new Document(
                String.format("Title: %s\nAbstract: %s\nContent: %s", title, abstractText, content),
                metadata
        );
        vectorStore.add(List.of(document));
    }

    public List<Document> searchPapers(String query, int topK) {
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
                .topK(topK)
                .build();
        return vectorStore.similaritySearch(searchRequest);
    }

    public String buildContext(String query) {
        List<Document> relevantDocs = searchPapers(query, 3);
        if (relevantDocs.isEmpty()) {
            return "未找到相关文献。";
        }
        StringBuilder context = new StringBuilder("相关文献参考：\n\n");
        for (int i = 0; i < relevantDocs.size(); i++) {
            Document doc = relevantDocs.get(i);
            context.append("--- 文献 ").append(i + 1).append(" ---\n");
            context.append(doc.getContent()).append("\n\n");
        }
        return context.toString();
    }
}
