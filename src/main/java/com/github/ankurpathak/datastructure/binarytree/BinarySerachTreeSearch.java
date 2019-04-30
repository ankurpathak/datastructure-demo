package com.github.ankurpathak.datastructure.binarytree;

import java.util.Arrays;

public class BinarySerachTreeSearch {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.addAll(Arrays.asList(10,5,-1,7,15,19,20,21));
        Node result = search(binarySearchTree.getRoot(), 99);
        System.out.println(result);
    }


    public  static <T extends Comparable<T>> Node<T> search(Node<T> node, T key){
        if(node == null)
            return null;
        int result = key.compareTo(node.getData());
        if(result == 0)
            return node;
        else if(result < 0)
            return search(node.getLeft(), key);
        else
            return search(node.getRight(), key);
    }
}
