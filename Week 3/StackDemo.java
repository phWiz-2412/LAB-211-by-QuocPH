import java.util.Stack;

class MyStack {
    private Stack<Integer> stackValues;

    public MyStack() {
        stackValues = new Stack<>();
    }

    public void push(int value) {
        stackValues.push(value);
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (!stackValues.isEmpty()) {
            int value = stackValues.pop();
            System.out.println("Popped: " + value);
            return value;
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    public int get() {
        if (!stackValues.isEmpty()) {
            return stackValues.peek();
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top value: " + stack.get());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
