class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    void insert(int value) {
        if(head == null) {
            head = new Node(value);
        }
        else {
            insertNode(value, head);
        }
    }

    private void insertNode(int value, Node node) {
        while(node.tail != null) {
            node = node.tail;
        }

        node.tail = new Node(value);
    }

    void delete(int value) {
        Node node = head;
        Node prev = null;
        Node next = null;

        if(head.head == value) {
            Node temp = head;
            head = head.tail;
            //return temp;
        }

        prev = node;
        node = node.tail;
        next = node.tail;

        while(node.head != value && next != null) {
            prev = node;
            node = node.tail;
            next = node.tail;
        }

        if(node.head == value) {
            prev.tail = next;
        }
    }

    void find(int value) {
        Node node = head;

        while(node != null && node.head != value) {
            node = node.tail;
        }

        if(node != null) {
            System.out.println("Found it");
        }
        else {
            System.out.println("Could not find it");
        }
    }

    void print() {
        String str = "";
        Node node = head;

        while(node != null) {
            System.out.printf("( %s ) -> ", node.head);
            node = node.tail;
        }

        System.out.print("null\n");
    }
}

class Node {
    int head;
    Node tail;

    Node(int x) {
        head = x;
        tail = null;
    }
}


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(7);
        list.insert(8);
        list.insert(5);
        list.insert(11);
        list.insert(27);
        list.insert(2);
        list.insert(9);
        list.insert(3);
        list.find(27);
        list.delete(27);
        list.print();
        list.find(27);

    }
}