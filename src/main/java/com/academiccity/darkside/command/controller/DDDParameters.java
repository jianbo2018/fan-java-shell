package com.academiccity.darkside.command.controller;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author jianbo
 * @Date 2023/2/1 16:13
 * @Version 1.0
 * @Description <br/>
 *
 */
public class DDDParameters {
    @NotBlank
    private String dddType;
//    @MustIn(list = Enum.)
    private String operator;
    @NotBlank
    @Length(max = 100)
    private String projectName;
}
