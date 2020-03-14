package Stack_Queue.탑;

import java.util.*;

class Solution {
    public int[] solution(int[] heights) {


        Stack<Integer> stack = new Stack<>();
        int length = heights.length;

        for(int i = length - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(heights[i] < heights[j]) {
                    stack.push(j+1);
                    break;
                }
                if(j == 0) stack.push(0);
            }
        }

        stack.push(0);

        int[] answer = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()) {
            answer[index++] = stack.pop();

        }

        return answer;
    }
}