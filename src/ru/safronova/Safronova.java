package ru.safronova;

import java.util.Random;

class Safronova {

    public static void main(String[] args) {
        final int SIZE = 200000;
        final int MAX = 500000;
        int[] data = new int[SIZE];
        Random random = new Random();

        //Создаём массив из SIZE случайных чисел от 0 до MAX
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(MAX);
        }

        BinaryTree bt1 = new BinaryTree();
        long start;
        long end;
        int[] data1 = {1,2,3,4,5,5,4};

        //Заполняем дерево уникальными значениями из массива data
        start = System.nanoTime();
        bt1.inflateTree(data1);
        end = System.nanoTime();
        System.out.printf("Дерево заполнено за %f секунды%n", ((end - start) / 1000000000.0));
        System.out.printf("Размер дерева: %d элементов%n%n", bt1.getTreeSize());

        //Считаем листья
        start = System.nanoTime();
        int leafCounter = bt1.countLeaf();
        end = System.nanoTime();
        System.out.printf("Количество листьев найдено за %f секунды%n", ((end - start) / 1000000000.0));
        System.out.println("Количество листьев: " + leafCounter);
        System.out.println("Root.value: " + bt1.root.value);
    }
}

class BinaryTree {
     static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

     Node root;

    //Распределяем узлы по уникальному значению (бинарное дерево поиска)
    private Node newNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = newNode(current.left, value);
        }
        if (value > current.value) {
            current.right = newNode(current.right, value);
        }
        return current;
    }

    //Наполняем  дерево
    public void inflateTree(int[] data) {
        for (int value : data) {
            root = newNode(root, value);
        }
    }

    //Счётчик листьев ---------------------------------------------!!
    private int leafCounter(Node current) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null) {
            return 1;
        }
        return leafCounter(current.left) + leafCounter(current.right);
    }

    public int countLeaf() {
        return leafCounter(root);
    }

    //Количество узлов дерева
    private int treeSize(Node current) {
        if (current != null) {
            return 1 + treeSize(current.left) + treeSize(current.right);
        } else return 0;

    }

    public int getTreeSize() {
        return treeSize(root);
    }

}