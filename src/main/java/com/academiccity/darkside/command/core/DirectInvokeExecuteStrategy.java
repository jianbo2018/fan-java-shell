package com.academiccity.darkside.command.core;

/**
 * @Author jianbo
 * @Date 2023/3/2 16:52
 * @Version 1.0
 * @Description <br/>
 *
 */
public class DirectInvokeExecuteStrategy implements ExecuteStrategy {

    private FanShell shell;

    public DirectInvokeExecuteStrategy(FanShell shell) {
        this.shell = shell;
    }

    @Override
    public boolean match(ShellCommand shellCommand) {
        return shellCommand!=null && !shellCommand.isNeedManualInput();
    }

    @Override
    public void doInvoke(ShellCommand shellCommand) {
        shell.exec(shellCommand.getCmdStr());
    }
}
