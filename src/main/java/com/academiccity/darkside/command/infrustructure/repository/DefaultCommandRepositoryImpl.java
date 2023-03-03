package com.academiccity.darkside.command.infrustructure.repository;

import com.academiccity.darkside.command.core.CommandRepository;
import com.academiccity.darkside.command.core.ShellCommand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * @Author jianbo
 * @Date 2023/2/3 14:20
 * @Version 1.0
 * @Description <br/>
 *
 */
@Component
public class DefaultCommandRepositoryImpl implements CommandRepository {

    @Resource
    private CommandFileReader reader;

    @Override
    public ShellCommand find(LinkedList<String> ops) {
        return reader.read(ops);
    }
}
