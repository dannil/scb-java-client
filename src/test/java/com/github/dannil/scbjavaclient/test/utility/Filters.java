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

    public static void files(Collection<File> files, String... names) {
        files(files, true, names);
    }

    public static void files(Collection<File> files, boolean recursive, String... names) {
        Iterator<File> it = files.iterator();
        while (it.hasNext()) {
            File f = it.next();
            String binaryName = Files.fileToBinaryName(f);
            for (int i = 0; i < names.length; i++) {
                // Figure out if input name is class or package. If the character after
                // the last dot separator is an capital letter, it's a class, otherwise a
                // package (or other undefined input)
                String name = names[i];
                char c = name.charAt(name.lastIndexOf('.') + 1);
                if (Character.isUpperCase(c)) {
                    if (Objects.equals(binaryName, name)) {
                        it.remove();
                    }
                } else {
                    String binaryNameWithoutClassName = binaryName.substring(0, binaryName.lastIndexOf('.'));
                    if (recursive) {
                        if (binaryNameWithoutClassName.contains(name)) {
                            it.remove();
                        }
                    } else {
                        if (Objects.equals(binaryNameWithoutClassName, name)) {
                            it.remove();
                        }
                    }
                }

            }
        }
    }

}
