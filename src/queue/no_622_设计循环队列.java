package queue;

import java.util.LinkedList;

public class no_622_设计循环队列 {
    class MyCircularQueue {


        private class Node{
            int val;
            Node next;
            Node(int x){val = x;}
        }


        Node head = null;
        Node tail = null;
        Node start = null;
        Node end = null;
        int size = 0;
        int volume =0;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            volume = k;
            while (k>0){
                Node node = new Node(-1);
                if(head==null && tail==null){
                    head=node;
                    tail=node;
                }else {
                    tail.next = node;
                    tail = node;
                }
                k=k-1;
            }
            tail.next = head;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size>=volume){
                return false;
            }
            if(start==null && end == null){
                head.val = value;
                start = head;
                end = head;
            }else {
                end.next.val = value;
                end=end.next;
            }
            size=size+1;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(size==0){
                return false;
            }
            start=start.next;
            size=size-1;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {

            if(size==0){
                return -1;
            }
            return start.val;
        }

        /** Get the last item from the queue. */
        public int Rear() {

            if(size==0){
                return -1;
            }
            return end.val;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size==volume;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
