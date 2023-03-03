package com.academiccity.darkside.command.core;

/**
 * @Author jianbo
 * @Date 2023/3/2 15:35
 * @Version 1.0
 * @Description <br/>
 *
 */
public interface ExecuteStrategy {
    boolean match(ShellCommand shellCommand);

    void doInvoke(ShellCommand shellCommand);
}
