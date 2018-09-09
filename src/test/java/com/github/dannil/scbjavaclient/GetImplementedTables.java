package com.github.dannil.scbjavaclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.client.SCBClientBuilder;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.test.utility.Files;
import com.github.dannil.scbjavaclient.test.utility.Filters;

import org.joda.time.DateTime;

public class GetImplementedTables {

    public Collection<String> getImplementedTables()
            throws ReflectiveOperationException, InterruptedException, IOException {
        String execPath = System.getProperty("user.dir");

        // Find files matching the wildcard pattern
        List<File> files = Files.find(execPath + "/src/main/java/com/github/dannil/scbjavaclient/client", "*.java");

        // Filter out some classes from the list
        Filters.files(files, AbstractClient.class, AbstractContainerClient.class, SCBClient.class, SCBClientBuilder.class);

        Collection<String> tables = new TreeSet<>(Collator.getInstance());
        for (File f : files) {
            // Convert path into binary name
            String binaryName = Files.fileToBinaryName(f);
            if (binaryName.endsWith("package-info")) {
                continue;
            }

            // Reflect the binary name into a concrete Java class
            Class<?> clazz = null;
            try {
                clazz = Class.forName(binaryName);
            } catch (ClassNotFoundException e) {
                // Class could not be created; respond with an assertion that'll always
                // fail
                e.printStackTrace();
                continue;
            }

            Object instance = clazz.newInstance();
            URLEndpoint url = (URLEndpoint) clazz.getMethod("getUrl", new Class<?>[] {}).invoke(instance,
                    new Object[] {});
            
            tables.add(url.getTable());

            // Figure out implemented tables by inspecting the source code
            List<String> lines = java.nio.file.Files.readAllLines(Paths.get(f.getPath()), StandardCharsets.UTF_8);
            String table = "";
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
                if (trimmedLine.contains("return generate") || trimmedLine.contains("return getResponseModels")) {
                    int beginIndex = trimmedLine.indexOf('"') + 1;
                    int endIndex = trimmedLine.indexOf('"', beginIndex + 2);
                    if (beginIndex > 0 && endIndex > 0) {
                        table = trimmedLine.substring(beginIndex, endIndex);

                        URLEndpoint endpoint = url.append(table);
                        tables.add(endpoint.getTable());
                    }
                }
            }
            if (tables.isEmpty()) {
                continue;
            }
        }
        return tables;
    }

    public static void main(String[] args) throws Exception {
        GetImplementedTables t = new GetImplementedTables();
        Collection<String> tables = t.getImplementedTables();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String date = LocalDateTime.now().format(formatter).replace(':', '-');
        
        String fileName = "tables_implemented_" + date + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : tables) {
                bw.write(s);
                bw.newLine();
            }
        }
    }

}
