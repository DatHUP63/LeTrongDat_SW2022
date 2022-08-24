package ex2;

import java.util.List;

public class Tree {
    String name;
    Integer key;
    List<Tree> childs;

    public Tree() {
    }

    public Tree(String name, Integer key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", key=" + key +
                ", childs=" + childs +
                '}';
    }
}
