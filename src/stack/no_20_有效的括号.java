package stack;

import java.util.Stack;

public class no_20_有效的括号 {

    public static void main(String[] agrs){

    }



    public boolean isValid(String s) {
        if(s == null || s==""){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char []  sArray = s.toCharArray();
        for (char c:sArray){
            if( c=='(' || c == '{' || c== '['){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }else if(c=='}'){
                if(stack.isEmpty() || stack.pop()!='{'){
                    return false;
                }
            }else if(c==']'){
                if( stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
}
