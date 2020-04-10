package Greedy.섬연결하기;
import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {

        int answer = 0;
        boolean [] visited = new boolean[n];
        boolean [] bridge = new boolean[costs.length];

        Arrays.sort(costs, new Comparator<int [] >(){
            public int compare(int [] a, int [] b) {
                return a[2] - b[2];
            }
        });

        visited[costs[0][0]] = true;
        visited[costs[0][1]] = true;
        bridge[0] = true;
        answer = costs[0][2];
        int island = 2;

        while(island < n) {
            for(int i = 1; i < bridge.length; i++) {
                if(!bridge[i]) {
                    if(!visited[costs[i][0]] && visited[costs[i][1]] || !visited[costs[i][1]] && visited[costs[i][0]]) {
                        bridge[i] = true;
                        visited[costs[i][0]] = true;
                        visited[costs[i][1]] = true;
                        answer+=costs[i][2];
                        island++;
                        break;
                    }
                }
            }
        }


        return answer;
    }
}