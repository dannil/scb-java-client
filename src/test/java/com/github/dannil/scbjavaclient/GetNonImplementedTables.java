package com.github.dannil.scbjavaclient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.github.dannil.scbjavaclient.GetImplementedTables;
import com.github.dannil.scbjavaclientutil.contents.SCBTreeStructure;

public class GetNonImplementedTables {

    public static void main(String[] args) throws IOException, ReflectiveOperationException, InterruptedException {
        SCBTreeStructure tree = new SCBTreeStructure(new Locale("sv", "SE"));

        File f = new File("scb_2018-06-15T10-12-11.947_2018-06-15T10-43-35.304_en.json");
        Collection<String> allTables = tree.getTables("", f);
        System.out.println("ALL size: " + allTables.size());
        // for (String e : allTables) {
        // // System.out.println(e);
        // }

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String now = LocalDateTime.now().format(formatter).replace(':', '-');

        GetImplementedTables t1 = new GetImplementedTables();
        Collection<String> implementedTables = t1.getImplementedTables();
        System.out.println("IMPLEMENTED size: " + implementedTables.size());

        String implementedName = "tables_implemented_" + now + ".txt";
        FileWriter writer1 = new FileWriter(implementedName);
        for (String str : implementedTables) {
            writer1.write(str);
            writer1.write(System.getProperty("line.separator"));
        }
        writer1.close();

        // Filter out duplicates; if a table is present in both lists, it means that it is
        // implemented. All the tables that are left after filtering are the
        // non-implemented ones
        Collection<String> nonImplementedTables = new ArrayList<>(allTables);
        Iterator<String> it = nonImplementedTables.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if ("/".equals(next)) {
                it.remove();
            }
            for (String s : implementedTables) {
                if (Objects.equals(next, s)) {
                    it.remove();
                }
            }
        }
        System.out.println("NONIMPLEMENTED size: " + nonImplementedTables.size());

        String notImplementedName = "tables_notimplemented_" + now + ".txt";
        FileWriter writer2 = new FileWriter(notImplementedName);
        for (String str : nonImplementedTables) {
            writer2.write(str);
            writer2.write(System.getProperty("line.separator"));
        }
        writer2.close();
        
        String implementationPriorities = "implementation_priorities_" + now + ".txt";
        Map<String, Integer> priorities = tree.getImplementationPriority(f, t1.getImplementedTables());
        priorities = MapUtil.sortByValue(priorities);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(implementationPriorities))) {
            for (Map.Entry<String, Integer> entry : priorities.entrySet()) {
                bw.write(entry.getKey() + "=" + entry.getValue());
                bw.newLine();
            }
        }
    }

}
