package com.springai.scholarmind.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CitationFormatterTool {

    private static final Logger log = LoggerFactory.getLogger(CitationFormatterTool.class);

    public String formatBibtex(String authors, String title, String journal, int year, String volume, String pages, String doi) {
        String key = authors.split(",")[0].trim().toLowerCase() + year;
        return String.format("""
                @article{%s,
                  author    = {%s},
                  title     = {%s},
                  journal   = {%s},
                  year      = {%d},
                  volume    = {%s},
                  pages     = {%s},
                  doi       = {%s}
                }
                """, key, authors, title, journal, year, volume, pages, doi);
    }

    public String formatApa(String authors, int year, String title, String journal, String volume, String issue, String pages, String doi) {
        return String.format("%s (%d). %s. *%s*, *%s*(%s), %s. https://doi.org/%s",
                authors, year, title, journal, volume, issue, pages, doi);
    }

    public String formatMla(String authors, String title, String journal, String volume, String issue, int year, String pages) {
        return String.format("%s. \"%s.\" *%s*, vol. %s, no. %s, %d, pp. %s.",
                authors, title, journal, volume, issue, year, pages);
    }

    public String formatGbt7714(String authors, String title, String journal, int year, String volume, String issue, String pages) {
        return String.format("%s. %s[J]. %s, %d, %s(%s): %s.",
                authors, title, journal, year, volume, issue, pages);
    }
}
