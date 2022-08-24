package ex2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static List<Tree> treeList;

    public static void main(String[] args) {
        treeList = new ArrayList<>();

        Tree tree = new Tree("TuLV", 1);
        List<Tree> sChilds = new ArrayList<>();
        sChilds.add(new Tree("TuLV2.1", 21));
        sChilds.add(new Tree("TuLV2.2", 22));

        List<Tree> childs = new ArrayList<>();
        Tree tree2 = new Tree("TuLV2", 2);
        tree2.childs = sChilds;
        childs.add(tree2);
        childs.add(new Tree("TuLV3", 3));
        childs.add(new Tree("TuLV4", 4));
        childs.add(new Tree("TuLV5", 5));
        childs.add(new Tree("TuLV6", 6));

        tree.childs = childs;
        treeList.add(tree);

        System.out.println(tree.toString());

        String name = getTreeNameByKey(treeList,22);
        System.out.println("name :" + name);

    }

    public static String getTreeNameByKey(List<Tree> data, Integer key) {
        String name = "";
        for (Tree tree : data) {

            if (tree.key == key) {
                return tree.name;
            }
            if (tree.childs != null && tree.childs.size() > 0) {
                name = getTreeNameByKey(tree.childs, key);
            }
        }
        return name;
    }
}
