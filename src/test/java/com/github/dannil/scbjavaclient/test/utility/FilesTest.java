package com.github.dannil.scbjavaclient.test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.Test;

@Suite
public class FilesTest {

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = Files.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void findHasMatches() {
        String execPath = System.getProperty("user.dir");

        List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient/test/utility", "*");

        assertNotNull(files);
        assertEquals(8, files.size());
    }

    @Test
    public void findHasMatchesRecursive() {
        String execPath = System.getProperty("user.dir");

        List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient/format", "*");

        assertNotNull(files);
        assertEquals(5, files.size());
    }

    @Test
    public void findNoMatches() {
        String execPath = System.getProperty("user.dir");

        List<File> files = Files.find(execPath + "/src/test/java/com/github/dannil/scbjavaclient/test/utility",
                "ABCABCABC");

        assertNotNull(files);
        assertEquals(0, files.size());
    }

    @Test
    public void findNonExistingPath() {
        String execPath = System.getProperty("user.dir");

        assertThrows(IllegalArgumentException.class, () -> Files.find(execPath + "/ABC/ABC/ABC", "*"));
    }

    @Test
    public void fileToBinaryName() {
        File file = new File("random/elements/before/abc/this/is/a/path.txt");

        String binaryName = Files.fileToBinaryName(file);

        assertTrue(binaryName.contains("random.elements.before.abc.this.is.a.path"));
    }

    @Test
    public void fileToBinaryNameNullIndexOf() {
        File file = new File("random/elements/before/abc/this/is/a/path.txt");

        String binaryName = Files.fileToBinaryName(file, null);

        assertTrue(binaryName.contains("random.elements.before.abc.this.is.a.path"));
    }

    @Test
    public void fileToBinaryNameEmptyIndexOf() {
        File file = new File("random/elements/before/abc/this/is/a/path.txt");

        String binaryName = Files.fileToBinaryName(file, "");

        assertTrue(binaryName.contains("random.elements.before.abc.this.is.a.path"));
    }

    @Test
    public void fileToBinaryNameCutoffInMiddle() {
        File file = new File("random/elements/before/abc/this/is/a/path.txt");

        String binaryName = Files.fileToBinaryName(file, "before");

        assertTrue(binaryName.contains("before.abc.this.is.a.path"));
    }

    @Test
    public void fileToBinaryNameUnixSeparators() {
        File file = new File("abc/this/is/a/path.txt");

        String binaryName = Files.fileToBinaryName(file, "abc");

        assertEquals("abc.this.is.a.path", binaryName);
    }

    @Test
    public void fileToBinaryNameUnixSeparatorsNoExtension() {
        File file = new File("abc/this/is/a/path");

        String binaryName = Files.fileToBinaryName(file, "abc");

        assertEquals("abc.this.is.a.path", binaryName);
    }

    @Test
    public void fileToBinaryNameWindowsSeparators() {
        File file = new File("abc\\this\\is\\a\\path.txt");

        String binaryName = Files.fileToBinaryName(file, "abc");

        assertEquals("abc.this.is.a.path", binaryName);
    }

    @Test
    public void fileToBinaryNameWindowsSeparatorsNoExtension() {
        File file = new File("abc\\this\\is\\a\\path");

        String binaryName = Files.fileToBinaryName(file, "abc");

        assertEquals("abc.this.is.a.path", binaryName);
    }

}
