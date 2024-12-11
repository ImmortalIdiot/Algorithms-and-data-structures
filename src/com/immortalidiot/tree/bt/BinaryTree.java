package com.immortalidiot.tree.bt;

import com.immortalidiot.stack.CustomStack;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<E extends Integer> implements AbstractBinaryTree<E> {

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
        int treeHeight = getHeight(this);
        int maxWidth = (int) Math.pow(2, treeHeight) - 1;
        List<List<String>> levels = new ArrayList<>();

        for (int i = 0; i < treeHeight; i++) {
            List<String> level = new ArrayList<>(Collections.nCopies(maxWidth, "   "));
            levels.add(level);
        }

        fillLevels(this, levels, 0, 0, maxWidth - 1);

        for (List<String> level : levels) {
            for (String node : level) {
                sb.append(node);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void fillLevels(BinaryTree<E> node, List<List<String>> levels, int level, int left, int right) {
        if (node == null || level >= levels.size()) {
            return;
        }
        int mid = (left + right) / 2;
        levels.get(level).set(mid, String.format("%3s", node.key));

        fillLevels(node.left, levels, level + 1, left, mid - 1);
        fillLevels(node.right, levels, level + 1, mid + 1, right);
    }

    private int getHeight(BinaryTree<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
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

    @Override
    public List<AbstractBinaryTree<E>> breadthFirstSearch() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> current = queue.poll();
            result.add(current);

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
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

    //14 вариант: Метод для поиска максимальной суммы пути в бинарном дереве
    public int maxPathSum() {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        calculateMaxPathSum(this, maxSum);
        return maxSum[0];
    }

    private int calculateMaxPathSum(BinaryTree<E> node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, calculateMaxPathSum(node.left, maxSum));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right, maxSum));

        int currentSum = leftSum + rightSum + node.key.intValue();
        maxSum[0] = Math.max(maxSum[0], currentSum);

        return node.key.intValue() + Math.max(leftSum, rightSum);
    }
}
