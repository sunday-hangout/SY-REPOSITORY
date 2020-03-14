package Hash.전화번호목록;

class Solution {
    public boolean solution(String[] phoneBook) {

        boolean answer = true;
        int length;

        for(String s : phoneBook) {

            length = s.length();
            for(String r : phoneBook)
                if(r.length()>length && r.substring(0, length).equals(s)) return false;

        }

        return answer;

    }
}
