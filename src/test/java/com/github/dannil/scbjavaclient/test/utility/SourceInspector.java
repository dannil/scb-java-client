package com.github.dannil.scbjavaclient.test.utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SourceInspector {

    public static Map<String, String> getImplementedTables(Path pathToClass) throws IOException {
        List<String> lines = java.nio.file.Files.readAllLines(pathToClass, StandardCharsets.UTF_8);

        Map<String, String> tables = new LinkedHashMap<>();

        String beginningOfMethod = "List<ResponseModel>";
        String method = null;
        String table = null;
        for (String line : lines) {
            // Skip line if it is a comment, Javadoc or alike
            String trimmedLine = line.trim();
            String[] comments = { "//", "/**", "/*", "*", "*/" };
            boolean offendingLine = false;
            for (int i = 0; i < comments.length; i++) {
                if (trimmedLine.startsWith(comments[i])) {
                    offendingLine = true;
                }
            }
            if (offendingLine) {
                continue;
            }
            if (trimmedLine.contains(beginningOfMethod)) {
                int beginIndex = trimmedLine.indexOf(beginningOfMethod) + beginningOfMethod.length() + 1;
                int endIndex = trimmedLine.indexOf('(', beginIndex + 1);
                method = trimmedLine.substring(beginIndex, endIndex);
            }
            if (method != null
                    && (trimmedLine.contains("return generate") || trimmedLine.contains("return getResponseModels"))) {
                int beginIndex = trimmedLine.indexOf('"') + 1;
                int endIndex = trimmedLine.indexOf('"', beginIndex + 2);
                if (beginIndex > 0 && endIndex > 0) {
                    table = trimmedLine.substring(beginIndex, endIndex);
                    tables.put(method, table);
                    method = null;
                }
            }
        }
        return tables;
    }

    public static Map<String, List<String>> getParameters(Path pathToClass) throws IOException {
        List<String> lines = java.nio.file.Files.readAllLines(pathToClass, StandardCharsets.UTF_8);

        Map<String, List<String>> parameters = new LinkedHashMap<>();

        String beginningOfMethod = "List<ResponseModel>";
        String method = null;
        boolean isDeprecated = false;
        for (String line : lines) {
            // Skip line if it is a comment, Javadoc or alike
            String trimmedLine = line.trim();
            String[] comments = { "//", "/**", "/*", "*", "*/" };
            boolean offendingLine = false;
            for (int i = 0; i < comments.length; i++) {
                if (trimmedLine.startsWith(comments[i])) {
                    offendingLine = true;
                }
            }
            if (offendingLine) {
                continue;
            }
            if (trimmedLine.contains("@Deprecated")) {
                isDeprecated = true;
            }
            if (trimmedLine.contains(beginningOfMethod) && !isDeprecated) {
                int beginIndex = trimmedLine.indexOf(beginningOfMethod) + beginningOfMethod.length() + 1;
                int endIndex = trimmedLine.indexOf('(', beginIndex + 1);
                method = trimmedLine.substring(beginIndex, endIndex);
            } else if (trimmedLine.contains(beginningOfMethod) && isDeprecated) {
                isDeprecated = false;
                method = null;
            }
            if (method != null && trimmedLine.contains("Collection") && !trimmedLine.contains("mappings")) {
                String[] parts = trimmedLine.split(" ");
                List<String> forbiddenElements = Arrays.asList("Collection", "public", "List", "{", "}", ",", " ");
                for (int i = 0; i < parts.length; i++) {
                    String part = parts[i].replaceAll("[^a-zA-Z]", "");
                    boolean isForbidden = false;
                    for (String element : forbiddenElements) {
                        if (part == null || part.length() == 0 || part.contains(element)) {
                            isForbidden = true;
                        }
                    }
                    if (!isForbidden) {
                        if (parameters.containsKey(method)) {
                            List<String> temp = parameters.get(method);
                            if (!temp.contains(part)) {
                                temp.add(part);
                            }
                        } else {
                            List<String> params = new ArrayList<>();
                            params.add(part);
                            parameters.put(method, params);
                        }
                    }
                }
            }
        }
        return parameters;
    }

}
