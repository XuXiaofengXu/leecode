package stack;

import java.util.Stack;

public class no_232_用栈实现队列 {



    class MyQueue {


        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(!outStack.isEmpty()){
                return outStack.pop();
            }else if(!inStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
                return outStack.pop();
            }else {
                return -1;
            }
        }

        /** Get the front element. */
        public int peek() {
            if(!outStack.isEmpty()){
                return outStack.peek();
            }else if(!inStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
                return outStack.peek();
            }else {
                return -1;
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty()&&outStack.isEmpty();
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
}
