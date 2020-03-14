package Hash.완주하지못한선수;

import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {

        String answer = "";
        int val = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(int i = 0; i < participant.length; i++) {

            String person = participant[i];

            if(map.get(person) == null) {
                map.put(person,1);

            }
            else {
                int currentCount = map.get(person);
                map.put(person,currentCount+1);
            }


        }


        for(int i = 0; i < completion.length; i++) {
            String person = completion[i];
            int currentCount = map.get(person);
            map.put(person,currentCount - 1);

        }

        for(int i = 0; i < participant.length; i++) {
            String person = participant[i];
            if(map.get(person) == 1) {
                answer = person;
            }
        }


        return answer;
    }
}
