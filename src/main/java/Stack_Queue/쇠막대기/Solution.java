package Stack_Queue.쇠막대기;

import java.util.*;

class Solution {
    public int solution(String arrangement) {

        int answer = 0;
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < arrangement.length(); i++) {

            char c = arrangement.charAt(i);

            if(c==')') {

                s.pop();
                if(arrangement.charAt(i-1) == '(') {
                    answer += s.size();
                }
                else {
                    answer++;
                }

            }
            else {
                s.push('(');
            }


        }


        return answer;
    }
}
