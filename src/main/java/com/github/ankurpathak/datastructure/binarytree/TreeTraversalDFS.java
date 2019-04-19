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


class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;


    public void inOrder() {
        recInOrder(root);
        System.out.println();
    }

    public void preOrder() {
        recPreOrder(root);
        System.out.println();

    }

    public void postOrder() {
        recPostOrder(root);
        System.out.println();
    }


    public void addAll(Collection<T> datas){
        if(datas != null){
            datas.forEach(this::add);
        }
    }


    public void add(T data) {
        //root = recAddNode(root, data);
        root = iterativeAddNode(root, data);
    }


    private Node<T> iterativeAddNode(Node<T> node, T data){
        if(node == null)
            return newNode(data);
        Node<T> current = node;
        Node<T> parent = null;

        while (current != null){
            parent = current;
            int res = data.compareTo(current.data);
            if(res < 0)
                current = current.left;
            else if(res > 0)
                current = current.right;
            else return node;
        }

        int res = data.compareTo(parent.data);
        if(res < 0)
            parent.left = newNode(data);
        else parent.right = newNode(data);

        return node;
    }


    private  Node<T> recAddNode(Node<T> node, T data) {
        if (node == null) {
            return newNode(data);
        }

        int res = data.compareTo(node.data);

        if (res < 0) {
            node.left = recAddNode(node.left, data);
        } else if(res > 0) { // if duplicates are not allowed
            node.right = recAddNode(node.right, data);
        }
        return node;
    }

    private Node<T> newNode(T data) {
        return new Node<>(data);
    }


    private void recPreOrder(Node<T> node) {
        if (node != null) {
            System.out.printf("%s ", node.getData());
            recPreOrder(node.getLeft());
            recPreOrder(node.getRight());
        }
    }

    private void recInOrder(Node<T> node) {
        if (node != null) {
            recInOrder(node.getLeft());
            System.out.printf("%s ", node.getData());
            recInOrder(node.getRight());
        }
    }

    private void recPostOrder(Node<T> node) {
        if (node != null) {
            recPostOrder(node.getLeft());
            recPostOrder(node.getRight());
            System.out.printf("%s ", node.getData());
        }
    }


    public static class Node<T extends Comparable<T>> {

        public Node(T data) {
            this.data = data;
        }

        private Node<T> left, right;
        private T data;

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}



