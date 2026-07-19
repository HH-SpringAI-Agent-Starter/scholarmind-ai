package com.springai.scholarmind.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class ArxivSearchTool {

    private static final Logger log = LoggerFactory.getLogger(ArxivSearchTool.class);
    private static final String ARXIV_API_BASE = "http://export.arxiv.org/api/query";
    private final HttpClient httpClient;

    public ArxivSearchTool() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public String search(String query, int maxResults) {
        try {
            String encodedQuery = java.net.URLEncoder.encode(query, "UTF-8");
            String url = ARXIV_API_BASE + "?search_query=all:" + encodedQuery
                    + "&start=0&max_results=" + maxResults
                    + "&sortBy=relevance&sortOrder=descending";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(30))
                    .header("Accept", "application/xml")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("arXiv API search success: query={}, status={}", query, response.statusCode());
            return response.body();
        } catch (Exception e) {
            log.error("arXiv API search failed: query={}", query, e);
            return "论文搜索失败: " + e.getMessage();
        }
    }

    public String search(String query) {
        return search(query, 5);
    }
}
