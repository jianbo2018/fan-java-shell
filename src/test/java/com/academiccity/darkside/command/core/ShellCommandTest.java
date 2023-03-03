package com.academiccity.darkside.command.core;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShellCommandTest {


    static Pattern pattern = Pattern.compile("\\$\\{name\\}");
    static Pattern pattern1 = Pattern.compile("\\$\\{(.*?)\\}");

    @Test
    public void testPatternOnPlaceHolder() {
        String str1 = "hello, ${name}";
        assertTrue(pattern.matcher(str1).find());
        String str2 = "hello, ${name1}";
        assertFalse(pattern.matcher(str2).find());
        String str3 = "hello , ${com.fan.learn}";
        assertFalse(pattern.matcher(str3).find());
        String str4 = "hello, jianbo";
        assertFalse(pattern.matcher(str4).find());
    }

    @Test
    public void name() {
        String str = "        mvn archetype:generate \\\n" +
                "            -DgroupId=${groupName} \\\n" +
                "            -DartifactId=${artifactId} \\\n" +
                "            -Dversion=${version} \\\n" +
                "            -Dpackage=${packageName} \\\n" +
                "            -DarchetypeArtifactId=cola-framework-archetype-web \\\n" +
                "            -DarchetypeGroupId=com.alibaba.cola \\\n" +
                "            -DarchetypeVersion=4.3.1";

        ShellCommand shellCommand = new ShellCommand();
        shellCommand.setCmdStr(str);
        shellCommand.fillPlaceHolder("groupName", "com.fan.learn");
        shellCommand.fillPlaceHolder("artifactId", "learn-cmd");
        shellCommand.fillPlaceHolder("version", "1.0.0");
        shellCommand.fillPlaceHolder("packageName", "com.fan.learn.shell.command");

        System.out.println(shellCommand.getCmdStr());

    }
}