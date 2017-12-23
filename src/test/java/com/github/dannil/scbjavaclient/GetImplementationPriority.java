package com.github.dannil.scbjavaclient;

import java.io.File;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclientutil.contents.SCBTreeStructure;

public class GetImplementationPriority {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        SCBTreeStructure tree = new SCBTreeStructure(new Locale("en", "US"));
        
        File f = new File("scb_2017-06-23T19-41-45.395_2017-06-23T20-10-50.492_en.json");
        
        GetImplementedTables g = new GetImplementedTables();
        Collection<String> implementedTables = g.getImplementedTables();
        
        Map<String, Integer> priorities = tree.getImplementationPriority(f, implementedTables);
        
        Map<String, Integer> sortedPriorities = MapUtil.sortByValue(priorities);
        for (Map.Entry<String, Integer> entry : sortedPriorities.entrySet()) {
            System.out.println(entry);
        }
    }

}
