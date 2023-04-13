class BinaryTree {
    Node root;
    Node parent;

    BinaryTree() {
        root = null;
        parent = null;
    }

    void insert(int x) {
        insertNode(x, root);
    }

    void insertNode(int x, Node node) {
        if(root == null) {
            root = new Node(x);
            parent = root;
            //new Node(x);
        }
        else {

        }
    }

    void delete(int x) {
        //parent = root;
        deleteNode(x, root);
    }

    private void deleteNode(int x, Node node) {

    }

    int findSuccessor(Node node) {
        while(node != null) {
            node = node.left;
        }
        return 0;
    }

    void print() {
        prettyPrint(root, "", true);
    }

    void prettyPrint(Node node,String prefix, boolean isLeft) {
        if (node.right != null) {
            String str = String.format("%s%s", prefix, isLeft ? "|   ": "    ");
            prettyPrint(node.right, str, false);
        }
        System.out.printf("%s%s%s\n", prefix, isLeft ? "└── " : "┌── ", node.value);
        if (node.left != null) {
            String str = String.format("%s%s", prefix, isLeft ? "    ": "│   ");
            prettyPrint(node.left, str, true);
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int x) {
        value = x;
        left = null;
        right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(7);
        bt.insert(11);
        bt.insert(12);
        bt.insert(5);
        bt.insert(6);
        bt.insert(1);
        bt.insert(4);
        bt.insert(3);
        bt.print();
        bt.delete(6);
        bt.delete(11);
        bt.delete(4);
    }
}