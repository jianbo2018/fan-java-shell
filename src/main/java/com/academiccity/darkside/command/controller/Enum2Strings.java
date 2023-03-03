package com.academiccity.darkside.command.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author jianbo
 * @Date 2023/2/1 16:49
 * @Version 1.0
 * @Description <br/>
 *
 */
public class Enum2Strings {
    public static String[] getStringArray(Class<? extends Enum<?>> clazz) {
        Enum<?>[] enumConstants = clazz.getEnumConstants();
        String[] ans = enumConstants == null ? null : new String[enumConstants.length];
        Arrays.stream(Objects.requireNonNull(clazz.getEnumConstants()))
                .map(Enum::name)
                .collect(Collectors.toList())
                .toArray(ans);
        return ans;
    }
}
