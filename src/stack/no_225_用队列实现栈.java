package stack;

import java.util.LinkedList;
import java.util.Queue;

public class no_225_用队列实现栈 {
    class MyStack1{

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack1() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {

            if(queue1.isEmpty()){
                queue2.offer(x); //如果队列已满，则返回false. 不使用add
            }else {
                queue1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (!queue1.isEmpty()){
                Integer t = queue1.poll();  //如果队列为空，则返回null，不使用remove
                if(queue1.isEmpty()){
                    return t;
                }else {
                    queue2.offer(t);
                }
            }

            while (!queue2.isEmpty()){
                Integer t = queue2.poll();  //如果队列为空，则返回null，不使用remove
                if(queue2.isEmpty()){
                    return t;
                }else {
                    queue1.offer(t);
                }
            }
            return -1;
        }

        /** Get the top element. */
        public int top() {
            while (!queue1.isEmpty()){
                Integer t = queue1.poll();  //如果队列为空，则返回null，不使用remove
                queue2.offer(t);
                if(queue1.isEmpty()){
                    return t;
                }
            }

            while (!queue2.isEmpty()){
                Integer t = queue2.poll();  //如果队列为空，则返回null，不使用remove
                queue1.offer(t);
                if(queue2.isEmpty()){
                    return t;
                }
            }
            return -1;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty()&&queue2.isEmpty();
        }
    }

    class MyStack {

        Queue<Integer> inQueue;
        Queue<Integer> outQueue;
        Queue<Integer> temp;

        /** Initialize your data structure here. */
        public MyStack() {
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {   //每次新加入一个元素，都将它放在队头，实现转置
            inQueue.offer(x);
            while (!outQueue.isEmpty()){
                inQueue.offer(outQueue.poll());
            }
            temp = inQueue;
            inQueue = outQueue;
            outQueue = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return outQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return outQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return inQueue.isEmpty()&&outQueue.isEmpty();
        }
    }

}
