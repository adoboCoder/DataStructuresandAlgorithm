import java.util.Arrays;
import java.util.Stack;
class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.pop();

        while(!q.empty()){
            System.out.println(q.pop());
        }

    }
}