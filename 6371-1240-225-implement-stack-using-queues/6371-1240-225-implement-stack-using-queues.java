class MyStack {
    List<Integer> stack;
    int size;
    public MyStack() {
       stack = new ArrayList<>();
       stack.add(0); 
       size = 0;
    }
    
    public void push(int x) {
        stack.add(x);
        size += 1;

    }
    public int pop() {
        int temp = stack.get(size);
        stack.remove(size);
        size -= 1;
        return temp;
    }
    
    public int top() {
        return stack.get(size);
    }
    
    public boolean empty() {
        if(size > 0){
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */