class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        if(root == null) {
            root = new Node(value);
        }
        else {
            insertNode(value, root);
        }
    }

    void insertNode(int value, Node node) {
        if(node.value == value) {
            /* do nothing */
        }
        else if(value < node.value) {
            if(node.left == null) {
                node.left = new Node(value);
            }
            else {
                insertNode(value, node.left);
            }
        }
        else {
            if(node.right == null) {
                node.right = new Node(value);
            }
            else {
                insertNode(value, node.right);
            }
        }
    }

    void delete(int value) {
        deleteNode(value, root);
    }

    private void deleteNode(int value, Node node) {
        if(root.value == value) {
            if(root.left == null && root.right == null) {
                root = null;
            }
            else if(root.left != null) {
                // findPredecessor
            }
            else {
                // findSuccessor
            }
        }
        else {

        }
    }

    private int findPredecessor(Node node) {

    }

    private int findSuccessor(Node node) {

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
    Node right;
    Node left;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(11);
        bst.insert(12);
        bst.insert(5);
        bst.insert(6);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.print();
    }
}