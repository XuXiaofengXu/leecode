package queue;

import java.util.LinkedList;
import java.util.Queue;

public class no_206_反转链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    class Solution {
        public ListNode reverseList(ListNode head) {
            Queue<ListNode> queue = new LinkedList<>();
            ListNode point = head;
            ListNode res=null;
            while (point!=null){
                queue.offer(point);
                point=point.next;
            }
            while (!queue.isEmpty()) {
                point = queue.poll();
                point.next = res;
                res = point;
            }
            return res;
        }
    }
}
