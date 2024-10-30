package com.immortalidiot.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node<E> insertRecursive(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }

        int compare = element.compareTo(current.value);

        if (compare < 0) {
            current.leftChild = insertRecursive(current.leftChild, element);
        } else if (compare > 0) {
            current.rightChild = insertRecursive(current.rightChild, element);
        }
        return current;
    }

    @Override
    public boolean contains(E element) {
        return recursiveContains(root, element);
    }

    private boolean recursiveContains(Node<E> current, E element) {
        if (current == null) {
            return false;
        }

        int compare = element.compareTo(current.value);

        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return recursiveContains(current.leftChild, element);
        } else {
            return recursiveContains(current.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = recursiveSearching(root, element);

        if (node == null) {
            return null;
        }

        BinarySearchTree<E> branch = new BinarySearchTree<>();
        branch.root = node;

        return branch;
    }

    private Node<E> recursiveSearching(Node<E> current, E element) {
        if (current == null) {
            return null;
        }

        int compare = element.compareTo(current.value);

        if (compare == 0) {
            return current;
        } else if (compare < 0) {
            return recursiveSearching(current.leftChild, element);
        } else {
            return recursiveSearching(current.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return root != null ? root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return root != null ? root.rightChild : null;
    }

    @Override
    public E getValue() {
        return root != null ? root.value : null;
    }

    //14 вариант: Метод для поиска максимальной суммы пути в бинарном дереве
    public int maxPathSum() {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        calculateMaxPathSum(root, maxSum);
        return maxSum[0];
    }

    private int calculateMaxPathSum(Node<E> node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, calculateMaxPathSum(node.leftChild, maxSum));
        int rightSum = Math.max(0, calculateMaxPathSum(node.rightChild, maxSum));

        int currentSum = leftSum + rightSum + ((Integer) node.value);
        maxSum[0] = Math.max(maxSum[0], currentSum);

        return ((Integer) node.value) + Math.max(leftSum, rightSum);
    }

    public String toVisualizedTree() {
        if (root == null) return "";

        StringBuilder result = new StringBuilder();
        List<List<String>> lines = new ArrayList<>();
        List<Node<E>> currentLevel = new ArrayList<>();
        List<Node<E>> nextLevel = new ArrayList<>();
        int widestNode = 0;
        int nodesInLevel = 1;

        currentLevel.add(root);

        while (nodesInLevel > 0) {
            List<String> line = new ArrayList<>();
            nodesInLevel = 0;

            for (Node<E> node : currentLevel) {
                if (node == null) {
                    line.add(null);
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    String nodeValue = String.valueOf(node.value);
                    line.add(nodeValue);
                    widestNode = Math.max(widestNode, nodeValue.length());

                    nextLevel.add(node.leftChild);
                    nextLevel.add(node.rightChild);
                    if (node.leftChild != null) nodesInLevel++;
                    if (node.rightChild != null) nodesInLevel++;
                }
            }

            lines.add(line);
            currentLevel = new ArrayList<>(nextLevel);
            nextLevel.clear();
        }

        widestNode += widestNode % 2;
        int perPiece = lines.get(lines.size() - 1).size() * (widestNode + String.valueOf(root.value).length());

        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int halfPieceWidth = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char connector = ' ';
                    result.append(connector);

                    if (line.get(j) == null) {
                        result.append(" ".repeat(perPiece - 1));
                    } else {
                        result.append((" ").repeat(halfPieceWidth))
                                .append(j % 2 == 0 ? "/" : "\\")
                                .append((" ").repeat(halfPieceWidth));
                    }
                }
                result.append("\n");
            }

            for (String nodeValue : line) {
                if (nodeValue == null) nodeValue = "";
                int leftPad = (int) Math.ceil((perPiece - nodeValue.length()) / 2.0);
                int rightPad = (int) Math.floor((perPiece - nodeValue.length()) / 2.0);

                result.append(" ".repeat(leftPad)).append(nodeValue).append(" ".repeat(rightPad));
            }
            result.append("\n");

            perPiece /= 2;
        }
        return result.toString();
    }
}
