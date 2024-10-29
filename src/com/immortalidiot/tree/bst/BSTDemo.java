package com.immortalidiot.tree.bst;

public class BSTDemo {
    public static void main(String[] args) {
        exampleOutput();
    }

    private static void exampleOutput() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(18);
        bst.insert(9);
        bst.insert(6);

        System.out.println("Дерево содержит 7: " + bst.contains(7));
        System.out.println("Дерево содержит 20: " + bst.contains(20));

        AbstractBinarySearchTree<Integer> branch = bst.search(5);
        System.out.println("Значение корня поддерева: " + (branch != null ? branch.getValue() : "null"));

        System.out.println("Максимальная сумма пути в дереве: " + bst.maxPathSum());

        System.out.println(bst.toVisualizedString());
    }
}