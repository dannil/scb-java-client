package com.github.dannil.scbjavaclient.test.utility;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Filters {

    public static void files(Collection<File> files, Class<?>... filters) {
        files(files, Arrays.asList(filters));
    }

    public static void files(Collection<File> files, Collection<Class<?>> filters) {
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File f = it.next();
            for (Class<?> clazz : filters) {
                if (Objects.equals(Files.fileToBinaryName(f), clazz.getName())) {
                    it.remove();
                }
            }
        }
    }

}
