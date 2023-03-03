package com.academiccity.darkside.command.core;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class UnixShellTest {

    @Test
    public void name() {
        File file = new File("/Users/jianbo/tmp/");
        System.out.println(file.exists());
    }
}