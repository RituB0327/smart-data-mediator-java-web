package com.smartmediator.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryService {

    // 🔥 Synonym dictionary
    private static final Map<String, String> synonyms = new HashMap<>();

    static {
        synonyms.put("total", "sum");
        synonyms.put("overall", "sum");
        synonyms.put("average", "avg");
        synonyms.put("mean", "avg");
        synonyms.put("count", "count");
        synonyms.put("number", "count");
        synonyms.put("employees", "employee");
    }

    // 🔥 Detect intent
    public String detectIntent(String query) {

        query = normalize(query);

        if (query.contains("sum") || query.contains("avg") || query.contains("count")) {
            return "aggregation";
        }
        else if (query.contains("trend") || query.contains("over time")) {
            return "trend";
        }
        else if (query.contains("compare") || query.contains("difference")) {
            return "comparison";
        }

        return "default";
    }

    // 🔥 Normalize query using synonyms
    public String normalize(String query) {
        query = query.toLowerCase();

        for (String key : synonyms.keySet()) {
            query = query.replace(key, synonyms.get(key));
        }

        return query;
    }

    // 🔥 Generate SQL
    public String generateSQL(String query, String intent) {

        switch (intent) {

            case "aggregation":
                if (query.contains("sum")) {
                    return "SELECT department, SUM(salary) as value FROM employee GROUP BY department";
                }
                else if (query.contains("avg")) {
                    return "SELECT department, AVG(salary) as value FROM employee GROUP BY department";
                }
                else {
                    return "SELECT department, COUNT(*) as value FROM employee GROUP BY department";
                }

            case "trend":
                return "SELECT join_date, COUNT(*) as value FROM employee GROUP BY join_date";

            case "comparison":
                return "SELECT department, salary FROM employee";

            default:
                return "SELECT * FROM employee LIMIT 10";
        }
    }

    // 🔥 Smart chart selection
    public String suggestChart(String intent) {

        switch (intent) {
            case "aggregation":
                return "bar";
            case "trend":
                return "line";
            case "comparison":
                return "bar";
            default:
                return "pie";
        }
    }
}