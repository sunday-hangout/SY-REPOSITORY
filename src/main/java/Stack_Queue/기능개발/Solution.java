package Stack_Queue.기능개발;

import java.util.*;
class Solution {


    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer>  deployments = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i ++) {

            int progress = progresses[i];
            int speed = speeds[i];
            int remain = 100 - progress;
            int completed = 0;
            if(remain % speed == 0) completed = remain / speed;
            else completed = (remain / speed) + 1;

            q.add(completed);
        }

        int currentJob = q.poll();
        int jobCount = 1;

        while(!q.isEmpty()) {

            int nextJob = q.poll();

            if(currentJob >= nextJob) {
                jobCount++;
            }
            else {
                deployments.add(jobCount);
                jobCount=1;
                currentJob = nextJob;
            }

        }

        deployments.add(jobCount);

        return deployments.stream().mapToInt(i -> i).toArray();
    }
}
