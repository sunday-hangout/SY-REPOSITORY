package Stack_Queue.다리를지나는트럭;
import java.util.*;

public class Solution {

    class Truck {
        int weight;
        int distance = 0;

        Truck(int weight) {
            this.weight = weight;
        }

        public void move() {
            this.distance++;
        }
    }

    class Bridge {

        int bridgeLength;
        int weight;
        int currentWeight;
        Queue<Truck> q = new LinkedList<>();

        Bridge(int bridgeLength, int weight) {
            this.bridgeLength = bridgeLength;
            this.weight = weight;
        }

        public boolean inTruck(Truck truck) {

            if(currentWeight + truck.weight > weight) return false;

            truck.move();
            currentWeight+= truck.weight;
            q.add(truck);
            return true;
        }

        public void outTruck() {
            Truck truck = q.peek();
            if(truck.distance > bridgeLength) {
                currentWeight -= truck.weight;
                q.poll();
            }
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public void moveTrucks() {
            for(Truck t : q) {
                t.move();
            }
        }

    }
    public int solution(int bridgeLength, int weight, int [] truckWeights) {

        Bridge bridge = new Bridge(bridgeLength,weight);
        Queue<Truck> ready = new LinkedList<>();
        int time = 0;

        Arrays.stream(truckWeights)
                .mapToObj(w -> new Truck(w))
                .forEach(ready::add);

        bridge.inTruck(ready.poll());
        time++;

        while(!bridge.isEmpty()) {

            time++;
            bridge.moveTrucks();
            bridge.outTruck();

            if(!ready.isEmpty()) {
                boolean result = bridge.inTruck(ready.peek());
                if(result) ready.poll();
            }
        }



        return time;
    }
}
