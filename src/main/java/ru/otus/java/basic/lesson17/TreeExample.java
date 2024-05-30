package ru.otus.java.basic.lesson17;

import java.util.ArrayList;
import java.util.List;

public class TreeExample {
    public static void main(String[] args) {
        Tree tree = new Tree("root");

        Tree dep1 = new Tree("dep1");
        Tree dep2 = new Tree("dep2");
        Tree dep3 = new Tree("dep3");

        Tree group11 = new Tree("group11");
        Tree group12 = new Tree("group12");

        Tree group21 = new Tree("group21");
        Tree group22 = new Tree("group22");

        Tree group31 = new Tree("group31");
        Tree group32 = new Tree("group32");

        tree.children = List.of(dep1, dep2, dep3);
        dep1.children = List.of(group11, group12);
        dep2.children = List.of(group21, group22);
        dep3.children = List.of(group31, group32);

       printStructure(tree, "");
    }

    public static void printStructure(Tree item, String prefix) {
        System.out.println(prefix + "->" + item.getName());
        for (Tree child: item.getChildren()) {
            printStructure(child, prefix + "->" + item.name);
        }
    }

    public static class Tree {
        String name;
        List<Tree> children = new ArrayList<>();

        public Tree(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Tree> getChildren() {
            return children;
        }

        public void setChildren(List<Tree> children) {
            this.children = children;
        }
    }
}
