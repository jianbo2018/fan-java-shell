package com.academiccity.darkside.command.core;

/**
 * @Author jianbo
 * @Date 2023/3/2 15:46
 * @Version 1.0
 * @Description <br/>
 *
 */
public class DummyExecuteStrategy implements ExecuteStrategy {
    @Override
    public boolean match(ShellCommand shellCommand) {
        return shellCommand == null;
    }

    @Override
    public void doInvoke(ShellCommand shellCommand) {
        System.out.println("找不到命令");
        //do nothing
    }
}
