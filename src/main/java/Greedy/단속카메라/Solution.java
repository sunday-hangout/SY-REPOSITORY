package Greedy.단속카메라;
import java.util.*;
public class Solution {

    public int solution(int [][] routes) {

        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int position = Integer.MAX_VALUE;

        for(int [] route : routes) {
            if(position < route[0]) {
                answer++;
                position = route[1];
            }
        }

        return answer;
    }
}
