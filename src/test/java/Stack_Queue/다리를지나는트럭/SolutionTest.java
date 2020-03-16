package Stack_Queue.다리를지나는트럭;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {



    @Test
    public void solution() {

        Stack_Queue.다리를지나는트럭.Solution s = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int [] truck_weights = {7,4,5,6};
        int answer = 8;
        Assert.assertEquals(answer,s.solution(bridge_length,weight,truck_weights));
    }

}