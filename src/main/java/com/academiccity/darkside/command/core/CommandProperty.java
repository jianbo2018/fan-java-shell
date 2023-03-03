package com.academiccity.darkside.command.core;

import lombok.Data;

/**
 * @Author jianbo
 * @Date 2023/3/2 05:53
 * @Version 1.0
 * @Description <br/>
 *
 */
@Data
public class CommandProperty {
    private String placeHolderName;
    //    private Class<?> valType;
    private Object value;
}
