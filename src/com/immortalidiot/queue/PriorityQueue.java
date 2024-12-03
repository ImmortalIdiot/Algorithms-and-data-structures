package com.immortalidiot.queue;

import com.immortalidiot.tree.bt.BinaryTree;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    private BinaryTree<E> root;
    private int size;

    public PriorityQueue() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(E element) {
        root = recursiveAdd(root, element);
        size++;
    }

    @Override
    public E peek() {
        return root == null ? null : findMax(root).getKey();
    }

    @Override
    public synchronized E poll() {
        if (root == null) {
            return null;
        }

        E max = peek();
        root = delete(root, max);
        size--;
        return max;
    }

    private BinaryTree<E> recursiveAdd(BinaryTree<E> tree, E object) {
        if (tree == null) {
            return new BinaryTree<>(object);
        }

        if (object.compareTo(tree.getKey()) < 0) {
            tree.setLeft(recursiveAdd((BinaryTree<E>) tree.getLeft(), object));
        } else {
            tree.setRight(recursiveAdd((BinaryTree<E>) tree.getRight(), object));
        }

        return tree;
    }

    private BinaryTree<E> findMax(BinaryTree<E> tree) {
        while (tree.getRight() != null) {
            tree = (BinaryTree<E>) tree.getRight();
        }

        return tree;
    }

    private BinaryTree<E> delete(BinaryTree<E> tree, E key) {
        if (tree == null) {
            return null;
        }

        if (key.compareTo(tree.getKey()) < 0) {
            tree.setLeft(delete((BinaryTree<E>) tree.getLeft(), key));
        } else if (key.compareTo(tree.getKey()) > 0){
            tree.setRight(delete((BinaryTree<E>) tree.getRight(), key));
        } else {
            if (tree.getLeft() == null) {
                return (BinaryTree<E>) tree.getRight();
            } else if (tree.getRight() == null) {
                return (BinaryTree<E>) tree.getLeft();
            }

            BinaryTree<E> max = findMax((BinaryTree<E>) tree.getLeft());
            tree.setKey(max.getKey());
            tree.setLeft(delete((BinaryTree<E>) tree.getLeft(), max.getKey()));
        }

        return tree;
    }
}
