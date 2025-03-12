class MyQueue {
    List<Integer> queue;
    int size;
    public MyQueue() {
        queue = new ArrayList<>();
        size = 0;
    }
    
    public void push(int x) {
        queue.add(x);
        size += 1;
    }
    
    public int pop() {
        if(size > 0){
            int temp = queue.get(0);
            queue.remove(0);
            size -= 1;
            return temp;
        }
        return -1;
    }
    
    public int peek() {
        if(size > 0){
            return queue.get(0);
        }
        return -1;
    }
    
    public boolean empty() {
        if(size > 0){
            return false;
        }
        return true;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */