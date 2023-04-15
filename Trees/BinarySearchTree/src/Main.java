import java.util.ArrayList;
import java.util.Arrays;

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

    public void insertArrayIntoBST(int[] nums) {
        root = sortedArrayToBST(nums);
    }

    public Node sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null; // base case

        int midpoint = (int) Math.floor((float)nums.length / 2); // round down to the nearest integer for the midpoint

        Node node = new Node(nums[midpoint]); // create new node from midpoint

        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midpoint)); // copy first half of array and use this for the next recursive call
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, midpoint+1, nums.length)); // copy second half of array and use this for the next recursive call

        return node;
    }

    void delete(int value) {
        root = deleteNode(value, root);
    }

    // recursively step through tree finding node to delete
    private Node deleteNode(int value, Node node) {
        if(node == null) return null;

        if(value < node.value) {
            node.left = deleteNode(value, node.left);
        }
        else if(value > node.value) {
            node.right = deleteNode(value, node.right);
        }
        else {
            if(node.left == null) {
                return node.right;
            }
            else if(node.right == null) {
                return node.left;
            }
            else {
                int v = findSuccessor(node.right); // find the value of the smallest child in right subtree
                node.value = v; // copy their value
                node.right = deleteNode(v, node.right); // delete the smallest child in the right subtree
            }
        }

        return node;
    }

    // returns the largest child in the left subtree
    private int findPredecessor(Node node) {
        int toReturn;

        while(node.right != null) {
            node = node.right;
        }

        toReturn = node.value;

        return toReturn;
    }

    // returns the smallest child in right subtree
    private int findSuccessor(Node node) {
        int toReturn;

        while(node.left != null) {
            node = node.left;
        }

        toReturn = node.value;

        return toReturn;
    }

    // returns the depth (distance from root) of a node
    void depthOfNode(int value) {
        Node node = root;
        int depthCounter = 0;
        boolean found = false;

        while(node != null) {
            if (value == node.value) {
                found = true;
                break;
            } else if (value < node.value) {
                node = node.left;
                depthCounter++;
            } else {
                node = node.right;
                depthCounter++;
            }
        }

        if(found) {
            System.out.printf("Node %s is at depth %s\n", value, depthCounter);
        }
        else {
            System.out.printf("Node %s could not be found in the tree", value);
        }
    }

    // searches the tree for a node with a specific value
    void find(int value) {
        Node node = findInTree(value);

        System.out.printf("Searching for %s...\n", value);

        if (node != null) {
            System.out.printf("Found %s in the tree\n", value);
        }
        else {
            System.out.printf("Could not find %s in the tree\n", value);
        }
    }

    // returns a node, if found, null otherwise
    Node findInTree(int value) {
        Node node = root;

        while(node != null) {
            if(value == node.value) {
                return node;
            }
            else if(value < node.value) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }

        return null;
    }

    // returns the height (distance to bottom-most leaf node) of the root node
    void heightOfTree() {
        int h = heightOfTree(root);
        System.out.printf("Root node has a height of: %s\n", h);
    }

    // returns height (distance to bottom-most leaf node) of a node
    void heightOfNode(int value) {
        Node node = findInTree(value);

        if(node != null) {
            int h = heightOfTree(node);
            System.out.printf("Node %s has a height of: %s\n", value, h);
        }
        else {
            System.out.printf("Node %s could not be found in the tree", value);
        }
    }

    // recursively gets the height of a node's left and right subtrees
    int heightOfTree(Node node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = heightOfTree(node.left); // height of left subtree
        int rightHeight = heightOfTree(node.right); // height of right subtree

        if(leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        else {
            return rightHeight + 1;
        }
    }

    // inorder traversal - LMR
    void inorder() {
        System.out.println("The tree inorder is: ");
        inorder(root);
    }

    private void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.printf("%s ", node.value);
            inorder(node.right);
        }
    }

    // preorder traversal - MLR
    void preorder() {
        System.out.println("The tree preorder is: ");
        preorder(root);
    }

    private void preorder(Node node) {
        if(node != null) {
            System.out.printf("%s ", node.value);
            preorder(node.left);
            preorder(node.right);
        }
    }

    // postorder traversal - LRM
    void postorder() {
        System.out.println("The tree postorder is: ");
        postorder(root);
    }

    private void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.printf("%s ", node.value);
        }
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
        /*BinarySearchTree bst = new BinarySearchTree();
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
        bst.find(7);
        bst.delete(7);
        bst.print();
        bst.find(7);
        bst.find(1);
        bst.find(2);
        bst.inorder();
        System.out.println();
        bst.preorder();
        System.out.println();
        bst.postorder();
        System.out.println();
        bst.depthOfNode(1);
        bst.depthOfNode(6);
        bst.depthOfNode(12);
        bst.depthOfNode(5);
        bst.depthOfNode(3);
        bst.heightOfNode(5);
        bst.heightOfTree();
        bst.heightOfNode(4);
        bst.heightOfNode(3);*/
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insertArrayIntoBST(new int[]{-10, -3, 0, 5, 9});
        bst2.print();
    }
}