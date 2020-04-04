package stack;

import java.util.Stack;

public class no_921_使括号有效的最少添加 {
    class Solution {
        public int minAddToMakeValid(String S) {
            char[] charArray = S.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(char c:charArray){
                if(c=='('){
                    stack.push('(');
                }else {
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }else {
                        stack.push(')');
                    }
                }
            }
            return stack.size();
        }
    }
}
