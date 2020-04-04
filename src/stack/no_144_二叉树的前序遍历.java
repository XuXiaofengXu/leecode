package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class no_144_二叉树的前序遍历 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *cur指向当前处理的节点
     * 1.当cur不为null，说明左子树可能存在，先访问当前节点的值，再将当前节点压进栈
     * 2.当cur为null，说明此路已经走到尽头，需要回退，弹出栈顶元素t，由于t已经访问过了，所以再将cur指向t的右子树
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> resList = new LinkedList<>();
            TreeNode cur = root;

            while (cur !=null || !stack.isEmpty()){
                if(cur != null){
                    resList.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    TreeNode t = stack.pop();
                    cur = t.right;

                }
            }

            return resList;

        }
    }
}
