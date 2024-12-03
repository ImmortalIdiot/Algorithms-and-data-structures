package com.immortalidiot.heap;

import com.immortalidiot.tree.bt.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private BinaryTree<E> root;
    private int size;

    public MaxHeap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public E peek() {
        return root == null ? null : root.getKey();
    }

    @Override
    public synchronized void add(E element) {
        BinaryTree<E> newNode = new BinaryTree<>(element);

        if (root == null) {
            root = newNode;
        } else {
            BinaryTree<E> parent = findNextParent();
            if (parent == null) return;

            if (parent.getLeft() == null) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }

            heapifyUp(newNode);
        }

        size++;
    }

    private BinaryTree<E> findNextParent() {
        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();

            if (current.getLeft() == null || current.getRight() == null) {
                return current;
            }

            queue.add((BinaryTree<E>) current.getLeft());
            queue.add((BinaryTree<E>) current.getRight());
        }

        return null;
    }

    private void heapifyUp(BinaryTree<E> treeNode) {
        while (root != treeNode) {
            BinaryTree<E> parent = findParent(root, treeNode);

            if (parent != null && parent.getKey().compareTo(treeNode.getKey()) < 0) {
                E object = parent.getKey();
                parent.setKey(treeNode.getKey());
                treeNode.setKey(object);
                treeNode = parent;
            } else { break; }
        }
    }

    private BinaryTree<E> findParent(BinaryTree<E> root, BinaryTree<E> child) {
        if (root == null || root == child) {
            return null;
        }

        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();

            if (current.getLeft() == child || current.getRight() == child) {
                return current;
            }

            if (current.getLeft() != null) { queue.add((BinaryTree<E>) current.getLeft()); }
            if (current.getRight() != null) { queue.add((BinaryTree<E>) current.getRight()); }
        }

        return null;
    }

    public void printAll() {
        if (root == null) {
            System.out.println("Heap is empty");
            return;
        }

        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();
            System.out.print(current.getKey() + "\t");

            if (current.getLeft() != null) {
                queue.add((BinaryTree<E>) current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add((BinaryTree<E>) current.getRight());
            }
        }
    }
}
