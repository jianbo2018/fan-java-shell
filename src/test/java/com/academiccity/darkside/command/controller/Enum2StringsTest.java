package com.academiccity.darkside.command.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Enum2StringsTest {
    @Test
    public void getStringArray() {
        String[] names = Enum2Strings.getStringArray(DemoE.class);
        assertEquals(names.length, DemoE.values().length);
        assertEquals("jianbo", names[0]);
        assertEquals("ruihua", names[1]);
        assertEquals("tongtong", names[2]);
    }

    enum DemoE {
        jianbo, ruihua, tongtong
    }
}