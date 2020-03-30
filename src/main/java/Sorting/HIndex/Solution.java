package Sorting.HIndex;
import java.util.*;


class Solution {
    public int solution(int[] citations) {


        Arrays.sort(citations);
        int answer = 0;
        int citationsCount = citations.length;
        int hIndex = 0;

        int max = citations[citationsCount-1];



        while(hIndex <= max) {

            int largeCount = 0;
            int smallCount = 0;

            for(int i = 0; i < citationsCount; i++) {
                if(citations[i] >=hIndex) largeCount++;
                else if(citations[i] <=hIndex) smallCount++;
            }

            if(largeCount < hIndex) break;

            answer = Math.max(answer,hIndex);
            hIndex++;

        }

        return answer;


    }
}