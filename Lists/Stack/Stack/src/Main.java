import java.util.ArrayList;

class Stack {
    ArrayList<Integer> s;

    Stack() {
        s = new ArrayList<>();
    }

    void pop() {
        s.remove(s.size() - 1);
    }

    void push(int value) {
        s.add(value);
    }

    void top() {
        System.out.printf("The top element of the stack is: %s%n", s.get(s.size() - 1));
    }

    void isEmpty() {
        if(s.isEmpty()) System.out.println("The stack is empty");
        else System.out.println("The stack is not empty");
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(11);
        stack.push(37);
        stack.top();
        stack.pop();
        stack.top();
        stack.pop();
        stack.isEmpty();
    }
}