package com.academiccity.darkside.command.core;

import org.junit.Test;

public class DefaultShellExecutorTest {

    @Test
    public void invoke() {
        ShellExecutor executor = new DefaultShellExecutor();
        executor.addLast(new ExecuteStrategy() {
            @Override
            public boolean match(ShellCommand shellCommand) {
                return shellCommand == null;
            }

            @Override
            public void doInvoke(ShellCommand shellCommand) {
                System.out.println("无效的command");
            }
        }).addLast(new ExecuteStrategy() {
            @Override
            public boolean match(ShellCommand shellCommand) {
                return shellCommand.isNeedManualInput();
            }

            @Override
            public void doInvoke(ShellCommand shellCommand) {
                System.out.println("manual invoke todo");
            }
        }).addLast(new ExecuteStrategy() {
            @Override
            public boolean match(ShellCommand shellCommand) {
                return shellCommand != null && !shellCommand.isNeedManualInput();
            }

            @Override
            public void doInvoke(ShellCommand shellCommand) {
                System.out.println("invoke directly");
            }
        });
        ShellCommand shellCommand = new ShellCommand();
//        shellCommand.setNeedManualInput(true);
        executor.invoke(shellCommand);
    }
}