package ro.vctr.binary;

public class BinaryTree {

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

