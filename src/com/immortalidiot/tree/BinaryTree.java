package com.immortalidiot.tree;

import com.immortalidiot.CustomStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {

    private E key;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(Math.max(0, indent)));
        sb.append(key).append("\n");

        if (left != null) {
            sb.append(left.asIndentedPreOrder(indent + 1));
        }

        if (right != null) {
            sb.append(right.asIndentedPreOrder(indent + 1));
        }

        return sb.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);

        if (left != null) {
            result.addAll(left.preOrder());
        }

        if (right != null) {
            result.addAll(right.preOrder());
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (left != null) {
            result.addAll(left.inOrder());
        }

        result.add(this);

        if (right != null) {
            result.addAll(right.inOrder());
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (left != null) {
            result.addAll(left.postOrder());
        }

        if (right != null) {
            result.addAll(right.postOrder());
        }

        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }

        consumer.accept(key);

        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> depthFirstSearch() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        CustomStack<AbstractBinaryTree<E>> stack = new CustomStack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            AbstractBinaryTree<E> current = stack.pop();
            result.add(current);

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        return result;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }
}
