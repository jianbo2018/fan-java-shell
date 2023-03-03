package com.academiccity.darkside.command.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * @Author jianbo
 * @Date 2023/3/2 15:35
 * @Version 1.0
 * @Description <br/>
 *
 */
@Component
public class DefaultShellExecutor implements ShellExecutor, InitializingBean {

    private LinkedList<ExecuteStrategy> strategyList = new LinkedList<>();

    @Resource
    private FanShell fanShell;

    @Override
    public void invoke(ShellCommand command) {
        strategyList.stream()
                .filter(strategy -> strategy.match(command))
                .findFirst()
                .get()
                .doInvoke(command);
    }

    @Override
    public ShellExecutor addLast(ExecuteStrategy strategy) {
        strategyList.addLast(strategy);
        return this;
    }

    @Override
    public ShellExecutor addFirst(ExecuteStrategy strategy) {
        strategyList.addFirst(strategy);
        return this;
    }

    @Override
    public ShellExecutor add(int index, ExecuteStrategy strategy) {
        strategyList.add(index, strategy);
        return this;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addLast(new DummyExecuteStrategy())
                .addLast(new ManualInputPropertyExecuteStrategy(fanShell))
                .addLast(new DirectInvokeExecuteStrategy(fanShell));
    }
}
