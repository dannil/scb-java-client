package com.github.dannil.scbjavaclient.test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.github.dannil.scbjavaclient.communication.http.requester.RequesterFactory;
import com.github.dannil.scbjavaclient.test.extensions.Suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Suite
public class FiltersTest {

    private File filtersFile;
    private File filtersTestFile;
    private File randomFile;

    private Collection<File> files;

    @BeforeEach
    public void setup() {
        this.files = new ArrayList<>();

        String execPath = System.getProperty("user.dir");

        this.filtersFile = new File(
                execPath + "/src/test/java/com/github/dannil/scbjavaclient/test/utility/Filters.java");
        this.filtersTestFile = new File(
                execPath + "/src/test/java/com/github/dannil/scbjavaclient/test/utility/FiltersTest.java");
        this.randomFile = new File(
                execPath + "/src/test/java/com/github/dannil/scbjavaclient/random/file/RandomFile.java");

        this.files.add(this.filtersFile);
        this.files.add(this.filtersTestFile);
        this.files.add(this.randomFile);
    }

    @Test
    public void callPrivateConstructor()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] cons = RequesterFactory.class.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object o = cons[0].newInstance();
        cons[0].setAccessible(false);

        assertNotNull(o);
    }

    @Test
    public void filterFilesWithClassesVarArgs() {
        Collection<Class<?>> filters = Arrays.asList(Filters.class);
        Filters.files(this.files, filters);

        assertEquals(2, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithClassesCollection() {
        Filters.files(this.files, Filters.class);

        assertEquals(2, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesDefault() {
        // Default (overloaded) method is recursive = true, so let's check that
        Filters.files(this.files, "com.github.dannil.scbjavaclient.test.utility");

        assertEquals(1, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertFalse(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveFalseWithClass() {
        Filters.files(this.files, false, "com.github.dannil.scbjavaclient.test.utility.Filters",
                "com.github.dannil.scbjavaclient.random.file.RandomFile");

        assertEquals(1, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertFalse(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveFalseWithPackageNoMatch() {
        Filters.files(this.files, false, "com.github.dannil.scbjavaclient.abc.abc.abc");

        assertEquals(3, this.files.size());
        assertTrue(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveFalseWithPackage() {
        Filters.files(this.files, false, "com.github.dannil.scbjavaclient.test.utility");

        assertEquals(1, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertFalse(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveTrueWithClass() {
        Filters.files(this.files, true, "com.github.dannil.scbjavaclient.test.utility.Filters");

        assertEquals(2, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveTrueWithPackageNoMatch() {
        Filters.files(this.files, true, "com.github.dannil.scbjavaclient.abc.abc.abc");

        assertEquals(3, this.files.size());
        assertTrue(this.files.contains(this.filtersFile));
        assertTrue(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

    @Test
    public void filterFilesWithNamesRecursiveTrueWithPackage() {
        Filters.files(this.files, true, "com.github.dannil.scbjavaclient.test.utility");

        assertEquals(1, this.files.size());
        assertFalse(this.files.contains(this.filtersFile));
        assertFalse(this.files.contains(this.filtersTestFile));
        assertTrue(this.files.contains(this.randomFile));
    }

}
