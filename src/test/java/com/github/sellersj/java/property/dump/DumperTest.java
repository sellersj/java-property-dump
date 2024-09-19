package com.github.sellersj.java.property.dump;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DumperTest {

    @Test
    void dumpAll() {
        String contents = Dumper.dumpAll();
        String expectedJavaVersion = System.getProperty("java.version");

        assertNotNull(contents);
        assertTrue(contents.contains(expectedJavaVersion));
    }
}
