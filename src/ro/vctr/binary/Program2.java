package ro.vctr.binary;

public class Program2 {
    public static void main(String[] args) {
        BinTree bt1 = new BinTree();
        long start;
        long end;

        //Count the leaves
        start = System.nanoTime();
        int leafCount = leafCounter(bt1.root);
        end = System.nanoTime();
        System.out.printf("Количество листьев найдено за %f секунды%n", ((end - start) / 1000000000.0));
        System.out.println("Количество листьев: " + leafCount);
    }

    //Leaf counter ---------------------------------------------!!
    private static int leafCounter(Node current) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null) {
            return 1;
        }
        return leafCounter(current.left) + leafCounter(current.right);
    }

}
class Node {
    Node left;
    Node right;

    Node() {
        left = null;
        right = null;
    }
}

class BinTree {

    Node root;

}
