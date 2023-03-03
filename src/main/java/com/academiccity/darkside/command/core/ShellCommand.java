package com.academiccity.darkside.command.core;

import lombok.Data;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author jianbo
 * @Date 2023/3/2 05:05
 * @Version 1.0
 * @Description <br/>
 *
 */
@Data
public class ShellCommand {
    private String cmdStr;
    private boolean needManualInput;
    private List<CommandProperty> propertyList;

    static final String prefixRegex = "\\$\\{";
    static final String postRegex = "\\}";

    public void fillPlaceHolder(String placeHolderName, String val) {
        String regex = prefixRegex + placeHolderName + postRegex;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cmdStr);
        if (m.find()) {
            cmdStr = m.replaceAll(val);
        }
    }
}
