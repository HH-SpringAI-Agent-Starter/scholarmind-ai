package com.springai.scholarmind.model;

public class ScholarResponse {

    private String content;
    private String category;
    private boolean success;
    private String error;

    public ScholarResponse() {
    }

    public ScholarResponse(String content, String category) {
        this.content = content;
        this.category = category;
        this.success = true;
    }

    public static ScholarResponse error(String errorMessage) {
        ScholarResponse response = new ScholarResponse();
        response.success = false;
        response.error = errorMessage;
        return response;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
