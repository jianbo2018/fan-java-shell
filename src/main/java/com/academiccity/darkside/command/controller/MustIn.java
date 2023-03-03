package com.academiccity.darkside.command.controller;

import java.lang.annotation.*;

/**
 * @Author jianbo
 * @Date 2023/2/1 16:43
 * @Version 1.0
 * @Description <br/>
 *
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MustIn {
    String[] list();
}
