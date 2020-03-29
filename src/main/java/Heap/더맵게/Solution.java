package Heap.더맵게;

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int food : scoville) {
            pq.add(food);
        }

        while(!pq.isEmpty() && pq.peek() < K) {
            int first = pq.poll();
            if(!pq.isEmpty()) {
                int second = pq.poll();
                pq.offer(first + (second * 2));
                answer++;
            }
            else {
                return -1;
            }
        }

        return answer;
    }
}