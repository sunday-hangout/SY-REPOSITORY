package Hash.베스트앨범;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {



    @Test
    public void solution() {

        Solution s = new Solution();

        String [] genres = {"classic","pop","classic","classic","pop"};
        int [] plays = {500, 600, 150, 800, 2500};
        int [] answer = {4,1,3,0};
        Assert.assertArrayEquals(answer,s.solution(genres,plays));

    }
}