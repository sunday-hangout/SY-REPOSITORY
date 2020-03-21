package Stack_Queue.주식가격;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {


        int length = prices.length;
        int [] answer = new int[length];
        int index = 0;

        for(int i = 0; i < length; i++) {

            int time = 0;

            for(int j = i+1; j < length; j++) {
                if(prices[i] > prices[j]) {
                    time ++;
                    break;
                }
                time++;
            }

            answer[index++] = time;
        }


        return answer;
    }
}

