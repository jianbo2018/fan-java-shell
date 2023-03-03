package com.academiccity.darkside.command.infrustructure.repository;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class DefaultCommandFileReaderTest {
    @Test
    public void afterProperties() throws Exception {
        DefaultCommandFileReader commandFileReader = new DefaultCommandFileReader();
        commandFileReader.afterPropertiesSet();
        commandFileReader.read(new LinkedList<>(Arrays.asList("ddd", "create", "cola")));
    }
}