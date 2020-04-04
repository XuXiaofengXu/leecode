package queue;

import java.util.*;

public class no_621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0){
            return 0;
        }

        //存放每个字母出现的次数
        HashMap<Character,Integer> hashMap = new HashMap<>(26);
        for (char c:tasks){
            if(hashMap.containsKey(c)){
                hashMap.replace(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }

        int cnt = 0;
        //优先队列，最大堆，从大到小排序
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(26,new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> t0, Map.Entry<Character, Integer> t1) {
                return t1.getValue().compareTo(t0.getValue());
            }
        });

        maxHeap.addAll(hashMap.entrySet());

        while (!maxHeap.isEmpty()){
            int i = 0;
            HashMap<Character,Integer> tempMap = new HashMap<>(26);
            Map.Entry<Character,Integer> entry = null;

            //每次取最大的n+1个
            while (i<=n){

                if(!maxHeap.isEmpty()){

                    entry=maxHeap.poll();
                    Integer newValue = entry.getValue()-1;
                    if(newValue>0){
                        entry.setValue(newValue);
                        tempMap.put(entry.getKey(),entry.getValue());
                    }
                }
                i++;
                cnt++;
                if(maxHeap.isEmpty()&&tempMap.isEmpty()){
                    break;
                }
            }
            maxHeap.addAll(tempMap.entrySet());
        }
        return cnt;

    }
}

// 总结：学会抽象问题，忽略次要因素。并非需要完全实现问题所需要的步骤，可对部分内容进行整合
