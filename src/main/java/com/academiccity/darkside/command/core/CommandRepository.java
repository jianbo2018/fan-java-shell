package com.academiccity.darkside.command.core;

import java.util.LinkedList;

public interface CommandRepository {
    ShellCommand find(LinkedList<String> ops);
}
