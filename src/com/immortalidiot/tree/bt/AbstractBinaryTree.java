package com.immortalidiot.tree.bt;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey();

    AbstractBinaryTree<E> getLeft();

    AbstractBinaryTree<E> getRight();

    void setKey(E key);

    String asIndentedPreOrder(int indent);

    List<AbstractBinaryTree<E>> preOrder();

    List<AbstractBinaryTree<E>> inOrder();

    List<AbstractBinaryTree<E>> postOrder();

    void forEachInOrder(Consumer<E> consumer);

    List<AbstractBinaryTree<E>> depthFirstSearch();

    List<AbstractBinaryTree<E>> breadthFirstSearch();
}
