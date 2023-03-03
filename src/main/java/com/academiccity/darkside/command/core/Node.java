package com.academiccity.darkside.command.core;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author jianbo
 * @Date 2023/2/2 22:28
 * @Version 1.0
 * @Description <br/>
 *
 */
@Data
public class Node {
    private String key;
    private String shellStr;
    private List<Node> children = new ArrayList<>();
    private Map map;

    public Node(Map map) {
        this.map = map;
    }

    public Node(String key) {
        this.key = key;
    }

    public Node(String key, Map map) {
        this.key = key;
        this.map = map;
    }

    public void addChild(Node node) {
        children.add(node);
    }
}
