package com.academiccity.darkside.command.infrustructure.repository;

import com.academiccity.darkside.command.core.Node;
import com.academiccity.darkside.command.core.ShellCommand;

import java.util.LinkedList;

public interface CommandFileReader {
    Node getRoot();

    ShellCommand read(LinkedList<String> ops);
}
