package com.github.ankurpathak.datastructure.binarytree;

import java.util.Collection;

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
        root = recAddNode(root, data);
        //root = iterativeAddNode(root, data);
    }


    private Node<T> iterativeAddNode(Node<T> node, T data){
        if(node == null)
            return newNode(data);
        Node<T> current = node;
        Node<T> parent = null;

        while (current != null){
            parent = current;
            int res = data.compareTo(current.getData());
            if(res < 0)
                current = current.getLeft();
            else if(res > 0)
                current = current.getRight();
            else return node;
        }

        int res = data.compareTo(parent.getData());
        if(res < 0)
            parent.setLeft(newNode(data));
        else parent.setRight(newNode(data));

        return node;
    }


    private  Node<T> recAddNode(Node<T> node, T data) {
        if (node == null) {
            return newNode(data);
        }

        int res = data.compareTo(node.getData());

        if (res < 0) {
            node.setLeft(recAddNode(node.getLeft(), data));
        } else if(res > 0) { // if duplicates are not allowed
            node.setRight(recAddNode(node.getRight(), data));
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


    public Node<T> getRoot() {
        return root;
    }
}
