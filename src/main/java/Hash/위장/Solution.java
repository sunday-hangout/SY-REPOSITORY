package Hash.위장;

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {

        int answer = 1;
        Map<String,Integer> map = new HashMap<>();

        for(String [] clothe : clothes) {
            String type = clothe[1];

            if(map.containsKey(type)) {
                map.put(type,map.get(type) + 1);
            }
            else {
                map.put(type,2);
            }
        }

        for(String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }
}
