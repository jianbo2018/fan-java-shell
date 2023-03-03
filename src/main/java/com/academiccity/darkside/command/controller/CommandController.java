package com.academiccity.darkside.command.controller;

import com.academiccity.darkside.command.core.CommandRepository;
import com.academiccity.darkside.command.core.ShellCommand;
import com.academiccity.darkside.command.core.ShellExecutor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author jianbo
 * @Date 2023/1/31 23:05
 * @Version 1.0
 * @Description <br/>
 *
 */
@ShellComponent
public class CommandController {
    @Resource
    private CommandRepository commandRepository;

    @Resource
    private ShellExecutor shellExecutor;

    /**
     * demo:
     * 1. fan-shell.yaml cola crt --name hello-world
     * 2. fan-shell.yaml cola crt hello-world
     */
    @ShellMethod("test")
    public void ddd(@ShellOption(arity = 2) String... ops) throws IOException {
        LinkedList<String> queryOps = new LinkedList<>();
        queryOps.add("ddd");
        queryOps.addAll(Arrays.asList(ops));
        ShellCommand shellCommand = commandRepository.find(queryOps);
        shellExecutor.invoke(shellCommand);
    }
}
