package com.immortalidiot.tree.bst;

public class BSTDemo {
    public static void main(String[] args) {
        exampleOutput();
    }

    private static void exampleOutput() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(9);
        bst.insert(15);
        bst.insert(4);
        bst.insert(11);
        bst.insert(18);
        bst.insert(9);
        bst.insert(6);
        bst.insert(13);
        bst.insert(16);
        bst.insert(2);
        bst.insert(1);
        bst.insert(8);
        bst.insert(-7);
        bst.insert(13);
        bst.insert(22);

        System.out.println("Дерево содержит 7: " + bst.contains(7));
        System.out.println("Дерево содержит 20: " + bst.contains(20));

        System.out.println("Максимальная сумма пути в дереве: " + bst.maxPathSum());

        System.out.println(bst.toVisualizedTree());
    }
}