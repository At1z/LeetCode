class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        shiftStacks();
        return output.pop();
    }

    public int peek() {
        shiftStacks();
        return output.peek();
    }
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void shiftStacks() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}

/**
 * Example usage:
 * MyQueue obj = new MyQueue();
 * obj.push(1);
 * obj.push(2);
 * int param_2 = obj.pop();   // Returns 1
 * int param_3 = obj.peek();  // Returns 2
 * boolean param_4 = obj.empty(); // Returns false
 */
