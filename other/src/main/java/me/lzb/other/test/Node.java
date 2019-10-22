package me.lzb.other.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by egan on 19/10/22
 */
public class Node {
    private int id;

    private int parentId;

    private List<Node> child;

    public Node(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setChild(List<Node> child) {
        this.child = child;
    }


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }


    public void addChild(Node node) {
        if (this.child == null) {
            this.child = new ArrayList<>();
        }

        child.add(node);
    }


    public static void main(String[] args) {
        //从数据库取出来的数据
        String json = "[{\"id\":7,\"parentId\":5},{\"id\":8,\"parentId\":5},{\"id\":1,\"parentId\":0},{\"id\":2,\"parentId\":1},{\"id\":3,\"parentId\":2},{\"id\":5,\"parentId\":1},{\"id\":6,\"parentId\":1}]";
        List<Node> allNodeList = JSON.parseArray(json, Node.class);
        System.out.println(JSON.toJSONString(allNodeList));

        List<Node> parentList = buildPrentSon(allNodeList);
        System.out.println(JSON.toJSONString(parentList));
    }


    private static List<Node> buildPrentSon(List<Node> list) {

        //先遍历一次把每一个节点装到hashmap里，id为key
        Map<Integer, Node> map = new HashMap<>();
        for (Node node : list) {
            map.put(node.getId(), node);
        }

        List<Node> parentList = new ArrayList<>();

        // 遍历第二次，
        // 如果是son，就根据parentid从map里把parent拿出来，把这个son添加到parent的son列表里，
        // 如果是顶层parent，就拿出来放到一个列表里，
        // 最后这个放顶层parent的列表就已经父子关系组织好了


        for (Node node : list) {
            //说明是最顶层的parent，放到parentList里
            if (node.getParentId() <= 0) {
//                parentList.add(node);

            } else {
                //个分支说明是子节点
                Node parent = map.get(node.getParentId());
                parent.addChild(node);
            }
        }




        return parentList;
    }

}
