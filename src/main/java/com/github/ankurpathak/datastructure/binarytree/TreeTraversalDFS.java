package com.github.ankurpathak.datastructure.binarytree;

import java.util.Arrays;
import java.util.Collection;

public class TreeTraversalDFS {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(10);
        binarySearchTree.add(15);
        binarySearchTree.add(5);
        binarySearchTree.add(7);
        binarySearchTree.add(19);
        binarySearchTree.add(20);
        binarySearchTree.add(-1);
        binarySearchTree.add(21);
        binarySearchTree.add(21);
        binarySearchTree.preOrder();


        BinarySearchTree<Integer> binarySearchTree1 = new BinarySearchTree<>();
        binarySearchTree1.addAll(Arrays.asList(10, 15, 5, 7, 19, 20, -1, 21,21));
        binarySearchTree1.preOrder();

    }

}



