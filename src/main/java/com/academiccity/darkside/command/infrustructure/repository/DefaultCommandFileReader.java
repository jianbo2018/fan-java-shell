package com.academiccity.darkside.command.infrustructure.repository;

import com.academiccity.darkside.command.core.CommandProperty;
import com.academiccity.darkside.command.core.Node;
import com.academiccity.darkside.command.core.ShellCommand;
import org.springframework.beans.factory.InitializingBean;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author jianbo
 * @Date 2023/2/2 23:16
 * @Version 1.0
 * @Description <br/>
 *
 */
public class DefaultCommandFileReader implements CommandFileReader, InitializingBean {

    static Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");

    private Node root;

    @Override
    public void afterPropertiesSet() throws Exception {
        Yaml yaml = new Yaml();
        URL cmdFileURL = this.getClass().getClassLoader().getResource("META-INF/fan-shell.yaml");
        File file = new File(cmdFileURL.toURI());
        try (FileReader reader = new FileReader(file)) {
            Map map = yaml.load(reader);
            root = new Node(map);
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node n = stack.pop();
                Map m = n.getMap();
                if (m != null) {
                    m.keySet().forEach(k -> {
                        Node cn;
                        if (m.get(k) instanceof Map) {
                            cn = new Node(k.toString(), ((Map) m.get(k)));
                        } else {
                            cn = new Node(k.toString());
                            cn.setShellStr(m.get(k).toString());
                        }
                        n.addChild(cn);
                        stack.push(cn);
                    });
                }
            }
        }
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public ShellCommand read(LinkedList<String> ops) {
        ShellCommand ans = new ShellCommand();
        Node cur = root;
        for (int i = 0; i < ops.size(); i++) {
            String key = ops.get(i);
            Node node = cur.getChildren().stream()
                    .filter(n -> n.getKey().equals(key))
                    .findFirst()
                    .get();
            cur = node;
        }
        List<Node> children = cur.getChildren();
        try {
            String shellStr = children.stream()
                    .filter(n -> n.getKey().equals("shell"))
                    .findFirst()
                    .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("找不到shell"))
                    .getShellStr();
            Matcher matcher = pattern.matcher(shellStr);
            List<CommandProperty> commandPropertyList = new ArrayList<>();
            while (matcher.find()) {
                ans.setNeedManualInput(true);
                String group = matcher.group();
                //去掉通配符，例如${groupName} --> groupName
                group = group.substring(2, group.length() - 1);
                CommandProperty property = new CommandProperty();
                property.setPlaceHolderName(group);
                commandPropertyList.add(property);
            }
            ans.setPropertyList(commandPropertyList);
            ans.setCmdStr(shellStr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
}
