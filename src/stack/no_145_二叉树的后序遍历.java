package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class no_145_二叉树的后序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> resStack = new Stack<>();
            TreeNode cur = root;

            while (cur !=null || !stack.isEmpty()){
                if(cur != null){
                    resStack.push(cur.val);
                    stack.push(cur);
                    cur = cur.right;
                }else {
                    TreeNode t = stack.pop();
                    cur = t.left;

                }
            }



            List<Integer> resList = new LinkedList<>();
            while (!resStack.isEmpty()){
                resList.add(resStack.pop());
            }
            return resList;
        }
    }


    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> resList = new LinkedList<>();
            TreeNode cur = root;
            TreeNode last = null;

            while (cur !=null || !stack.isEmpty()){
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else {

                    TreeNode t = stack.peek();
                    if(t.right == null){//右子树为空
                        stack.pop();
                        resList.add(t.val);
                        last = t;
                    }else {             //右子树不为空
                        if(t.right!=last){  //右子树没有访问过
                            cur = t.right;
                        }else {         //右子树已访问过
                            stack.pop();
                            resList.add(t.val);
                            last = t;
                        }
                    }
                }
            }

            return resList;

        }
    }
}
