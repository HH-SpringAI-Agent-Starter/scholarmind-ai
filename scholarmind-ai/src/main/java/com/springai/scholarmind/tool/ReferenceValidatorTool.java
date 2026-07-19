package com.springai.scholarmind.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReferenceValidatorTool {

    private static final Logger log = LoggerFactory.getLogger(ReferenceValidatorTool.class);

    public ValidationResult validate(String title, String doi, String authors, int year) {
        ValidationResult result = new ValidationResult();

        if (title == null || title.isBlank()) {
            result.addIssue("标题不能为空");
        }

        if (doi != null && !doi.isBlank()) {
            if (!doi.matches("^10\\.\\d{4,}/.+$")) {
                result.addIssue("DOI格式无效: " + doi);
            } else {
                result.setDoiValid(true);
            }
        }

        if (authors == null || authors.isBlank()) {
            result.addIssue("作者信息不能为空");
        }

        if (year <= 1900 || year > 2026) {
            result.addIssue("出版年份超出合理范围: " + year);
        }

        result.setValid(result.getIssues().isEmpty());
        log.info("Reference validation: title={}, valid={}, issues={}", title, result.isValid(), result.getIssues().size());
        return result;
    }

    public static class ValidationResult {
        private boolean valid;
        private boolean doiValid;
        private java.util.List<String> issues = new java.util.ArrayList<>();

        public boolean isValid() { return valid; }
        public void setValid(boolean valid) { this.valid = valid; }
        public boolean isDoiValid() { return doiValid; }
        public void setDoiValid(boolean doiValid) { this.doiValid = doiValid; }
        public java.util.List<String> getIssues() { return issues; }
        public void addIssue(String issue) { this.issues.add(issue); }

        @Override
        public String toString() {
            if (valid) return "✅ 参考文献验证通过";
            return "❌ 参考文献验证失败:\n  - " + String.join("\n  - ", issues);
        }
    }
}
