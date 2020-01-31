package ro.vctr.binary;

import java.util.Random;

class Program {

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

        //Заполняем дерево уникальными значениями из массива data
        start = System.nanoTime();
        bt1.inflateTree(data);
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