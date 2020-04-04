package queue;

import java.util.LinkedList;
import java.util.Queue;

public class no_933_最近的请求次数 {
    class RecentCounter {

        private Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty()){
                if(queue.peek() < t -3000){
                    queue.poll();
                }else {
                    break;
                }
            }
            queue.offer(t);
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
