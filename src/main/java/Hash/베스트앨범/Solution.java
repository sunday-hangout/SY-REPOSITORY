package Hash.베스트앨범;

import java.util.*;
class Solution {
    class Music implements Comparable<Music>{
        int id;
        int count;
        Music(int id, int count) {
            this.id = id;
            this.count = count;
        }
        @Override
        public int compareTo(Music m) {
            if(m.count == this.count) return this.id - m.id;
            return m.count - this.count;
        }
    }
    class MusicList {

        ArrayList<Music> list = new ArrayList<>();
        int count = 0;

        public void add(Music m) {
            list.add(m);
            this.count += m.count;
        }
        public int size() {
            return list.size();
        }
        public int getCount() {
            return this.count;
        }
        public Music getMusic(int index) {
            return list.get(index);
        }
    }
    public int[] solution(String[] genres, int[] plays) {


        int length = genres.length;
        Map<String,MusicList> map = new HashMap<>();

        for(int i = 0; i < length; i++) {
            if(map.containsKey(genres[i])) {
                MusicList beforeList = map.get(genres[i]);
                beforeList.add(new Music(i,plays[i]));
                map.put(genres[i],beforeList);
            }
            else {
                MusicList list = new MusicList();
                list.add(new Music(i,plays[i]));
                map.put(genres[i],list);
            }
        }

        List<String> keySetList = new ArrayList<>(map.keySet());

        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).getCount() - map.get(o1).getCount();
            }
        });

        for(String key : keySetList) {
            Collections.sort(map.get(key).list);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(String key : keySetList) {
            MusicList ml = map.get(key);
            if(ml.size()== 1){
                for(int i = 0; i < 1; i++) {
                    Music m = ml.getMusic(i);
                    list.add(m.id);
                }

            }
            else{
                for(int i = 0; i < 2; i++) {
                    Music m = ml.getMusic(i);
                    list.add(m.id);
                }
            }

        }


        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
            answer[i] = list.get(i);
        }

        return answer;
    }
}
