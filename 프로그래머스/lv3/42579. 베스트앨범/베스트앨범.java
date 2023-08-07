import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String,Integer> mapForCount = new HashMap<>();
        HashMap<String,PriorityQueue<Music>> mapForList = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            mapForCount.put(genres[i],mapForCount.getOrDefault(genres[i],0)+plays[i]);
            PriorityQueue<Music> pq = mapForList.get(genres[i]);
            if(pq==null){
                pq = new PriorityQueue<>();
            }
            pq.add(new Music(i,plays[i]));
                mapForList.put(genres[i],pq);
        }
        PriorityQueue<MusicTotal> pq1 = new PriorityQueue<>();
        mapForCount.forEach((key,value)->{
            pq1.add(new MusicTotal(key,value));
        });

        while(!pq1.isEmpty()){
            String name = pq1.poll().name;
            
            PriorityQueue<Music> pq = mapForList.get(name);
            
            Music music = pq.poll();
                ans.add(music.index);
            if(!pq.isEmpty()){
                music = pq.poll();
                ans.add(music.index);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
class Music implements Comparable<Music>{
    int index, plays;
    Music(int index, int plays){
        this.index = index;
        this.plays = plays;
    }
    @Override
    public int compareTo(Music o){
        if(this.plays==o.plays){
            return this.index-o.index;
        }
        return o.plays-this.plays;
    }
}

class MusicTotal implements Comparable<MusicTotal>{
    
    int count;
    String name;
    MusicTotal(String name,int count){
        this.count = count;
        this.name = name;
    }
    @Override
    public int compareTo(MusicTotal o){
        return o.count-this.count;
    }
}