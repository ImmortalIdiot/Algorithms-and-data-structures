package com.immortalidiot.tree.bst;

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

    public String toVisualizedString() {
        StringBuilder sb = new StringBuilder();
        visualizeTree(root, 0, sb);

        return sb.toString();
    }

    private void visualizeTree(Node<E> node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }

        visualizeTree(node.rightChild, depth + 1, sb);

        sb.append(" ".repeat(depth * 4));
        sb.append(node.value).append("\n");

        visualizeTree(node.leftChild, depth + 1, sb);
    }
}
