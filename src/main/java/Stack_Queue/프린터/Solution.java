package Stack_Queue.프린터;

import java.util.*;
class Solution {

    class Job implements Comparable<Job>{

        int location;
        int priority;
        public Job(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        @Override
        public int compareTo(Job j) {
            return j.priority - this.priority;
        }



    }

    public int solution(int[] priorities, int location) {

        int answer = 0;
        Queue<Job> ready = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>();


        //Job 추가
        for(int i = 0; i < priorities.length; i++) {
            Job job = new Job(i,priorities[i]);
            ready.add(job);
            pq.add(job);
        }

        while(!ready.isEmpty()) {

            Job job = ready.poll();

            //현재 출력할 작업의 우선순위가 가장 높으면 바로 인쇄한다.
            if(pq.peek().priority == job.priority) {

                pq.poll();
                answer++;

                //사용자가 찾기를 원하는 작업인 경우 탐색 종료
                if(location == job.location) {
                    break;
                }

            }
            else {

                //현재 출력할 작업의 우선순위보다 높은 작업이 있으면 현재 출력할 작업을 가장 뒤로 보낸다.
                ready.add(job);
            }

        }



        return answer;

    }
}
