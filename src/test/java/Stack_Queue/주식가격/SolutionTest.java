package Stack_Queue.주식가격;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solution() {

        Stack_Queue.주식가격.Solution s = new Solution();
        int [] prices = {1,2,3,2,3};
        int [] result = {4,3,1,1,0};
        assertArrayEquals(result,s.solution(prices));
    }

}