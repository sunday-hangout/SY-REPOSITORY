package Heap.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {


    class Request implements Comparable<Request> {

        int requestTime;
        int processTime;

        Request(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(Request r) {
            return this.processTime - r.processTime;
        }
    }


    public int solution(int[][] jobs) {

        PriorityQueue<Request> controller = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int []>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        int totalRequest = jobs.length;
        int time = 0;
        int index = 0;
        int sum = 0;

        while(true) {

            while(index < totalRequest && jobs[index][0] <= time) {
                controller.add(new Request(jobs[index][0],jobs[index][1]));
                index++;
            }

            if(!controller.isEmpty()) {
                Request req = controller.poll();
                time+=req.processTime;
                sum+=time-req.requestTime;
            }
            else {
                time = jobs[index][0];
            }

            if(index == totalRequest && controller.isEmpty()) break;

        }


        return sum/totalRequest;

    }

}
