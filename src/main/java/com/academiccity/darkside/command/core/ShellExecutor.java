package com.academiccity.darkside.command.core;

/**
 * @Author jianbo
 * @Date 2023/3/2 15:29
 * @Version 1.0
 * @Description <br/>
 *
 */
public interface ShellExecutor {
    void invoke(ShellCommand command);

    ShellExecutor addLast(ExecuteStrategy strategy);

    ShellExecutor addFirst(ExecuteStrategy strategy);

    ShellExecutor add(int index, ExecuteStrategy strategy);
}
