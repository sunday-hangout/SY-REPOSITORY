package Heap.라면공장;

import java.util.*;
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {

        int answer = 0;
        int index = 0;
        Queue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index]) pq.offer(supplies[index++]);
            if(stock == 0) {
                stock+=pq.poll();
                answer++;
            }
            stock--;

        }

        return answer;
    }
}