package stack;

import java.util.Stack;

public class no_155_最小栈 {
    class MinStack {

        Stack<Integer> normalStack ;
        Stack<Integer> minStack ;

        /** initialize your data structure here. */
        public MinStack() {

            normalStack = new Stack<>();
            minStack = new Stack<>();


        }

        public void push(int x) {
            normalStack.push(x);
            if(minStack.isEmpty() ||  x<=minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            if(!normalStack.isEmpty() && !minStack.isEmpty()){
                if( minStack.peek().equals(normalStack.pop())){        // 注意，Integer的值大小比较，不能用==，要用equals
                    minStack.pop();
                }
            }

        }

        public int top() {
            return normalStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
