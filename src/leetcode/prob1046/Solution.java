package leetcode.prob1046;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                return j-i;
            }
        });

        for(int stone: stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int stOne = pq.poll();
            int stTwo= pq.poll();
            int absDiff = Math.abs(stOne - stTwo);
            if(absDiff!=0) pq.add(absDiff);
        }
        return pq.size()==0?0:pq.peek();
    }
}