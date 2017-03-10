package com.github.dannil.scbjavaclient.test.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Files {

    public static List<File> find(String path, String partOfFile) {
        List<File> allFiles = new ArrayList<File>();
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                allFiles.addAll(find(file.getAbsolutePath(), partOfFile));
            } else {
                String partOfFileToRegex = ".*?" + partOfFile.replace("*", ".*?") + ".*?";
                if (file.getAbsolutePath().matches(partOfFileToRegex)) {
                    allFiles.add(file);
                }
            }
        }
        return allFiles;
    }

}
