package com.academiccity.darkside.command.core;

import java.util.Scanner;

/**
 * @Author jianbo
 * @Date 2023/3/2 16:47
 * @Version 1.0
 * @Description <br/>
 *
 */
public class ManualInputPropertyExecuteStrategy implements ExecuteStrategy {

    private FanShell shell;

    public ManualInputPropertyExecuteStrategy(FanShell shell) {
        this.shell = shell;
    }

    @Override
    public boolean match(ShellCommand shellCommand) {
        return shellCommand != null && shellCommand.isNeedManualInput();
    }

    @Override
    public void doInvoke(ShellCommand shellCommand) {
        for (CommandProperty property : shellCommand.getPropertyList()) {
            System.out.printf("请输入[%s]%n", property.getPlaceHolderName());
            Scanner scanner = new Scanner(System.in);
            String val = scanner.nextLine();
            property.setValue(val);
            shellCommand.fillPlaceHolder(property.getPlaceHolderName(), val);
        }
        shell.exec(shellCommand.getCmdStr());
    }
}
