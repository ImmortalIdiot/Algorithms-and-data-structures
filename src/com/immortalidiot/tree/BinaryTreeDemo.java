package com.immortalidiot.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        exampleOutput();
    }

    private static void exampleOutput() {
        BinaryTree<Integer> root = new BinaryTree<>(4);

        BinaryTree<Integer> leftChild = new BinaryTree<>(2);
        root.setLeft(leftChild);
        BinaryTree<Integer> rightChild = new BinaryTree<>(6);
        root.setRight(rightChild);

        leftChild.setLeft(new BinaryTree<>(1));
        leftChild.setRight(new BinaryTree<>(3));

        rightChild.setLeft(new BinaryTree<>(5));
        rightChild.setRight(new BinaryTree<>(7));

        System.out.println("Дерево в виде строки с отступами:");
        System.out.println(root.asIndentedPreOrder(0));

        System.out.println("Прямой (pre-order) обход:");
        root.preOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        System.out.println("Симметричный (in-order) обход:");
        root.inOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        System.out.println("Обратный (post-order) обход:");
        root.postOrder().forEach(node -> System.out.print(node.getKey() + " "));
        System.out.println();

        System.out.println("Печать элементов в порядке (in-order) с использованием Consumer:");
        root.forEachInOrder(element -> System.out.print(element + " "));
        System.out.println();
    }
}
