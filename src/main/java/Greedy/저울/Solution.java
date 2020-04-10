package Greedy.저울;

import java.util.*;


class Solution {
    public int solution(int[] weight) {

        Arrays.sort(weight);
        int sum = weight[0];

        for(int i = 1; i < weight.length; i++) {
            if(weight[i] > sum + 1) return sum + 1;
            sum+=weight[i];
        }
        return sum+1;
    }
}