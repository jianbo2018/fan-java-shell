package com.academiccity.darkside.command.component;

import com.academiccity.darkside.command.infrustructure.repository.DefaultCommandFileReader;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DefaultCommandFileReaderTest {
    @Test
    public void cmdName() {
        DefaultCommandFileReader reader = new DefaultCommandFileReader();
        String filePath = DefaultCommandFileReader.class.getClassLoader().getResource("")
                .getPath() + "application.yaml";

        String cmdName = ReflectionTestUtils.invokeMethod(reader, "cmdName", new File(filePath));
        assertNotNull(cmdName);
        assertEquals("application", cmdName);
    }
}