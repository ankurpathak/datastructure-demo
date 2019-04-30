package com.github.ankurpathak.datastructure.binarytree;

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


        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(10, true);
        binarySearchTree.add(15, true);
        binarySearchTree.add(5, true);
        binarySearchTree.add(7,  true);
        binarySearchTree.add(19, true);
        binarySearchTree.add(20, true);
        binarySearchTree.add(-1, true);
        binarySearchTree.add(21, true);
        binarySearchTree.add(21, true);
        binarySearchTree.preOrder();
    }
}



