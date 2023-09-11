import java.util.*;

class Solution {

  //Union-Find처럼 구현했다.
  //시간초과 발생...
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        HashSet<Long> set = new HashSet<>();
        HashMap<Long,Long> map = new HashMap<>();
        
        for(int i=0;i<room_number.length;i++){
            
            //없을경우 방 배정
            if(!set.contains(room_number[i])){
                set.add(room_number[i]);
                answer[i] = room_number[i];
                map.put(room_number[i],map.getOrDefault(room_number[i]+1,room_number[i]+1));
            }
            //있을경우 
            else{
                Long now = map.get(room_number[i]);
                while(map.get(now)!=null){
                    now = map.get(now);
                }
                answer[i] = now;
                set.add(now);
                map.put(now,map.getOrDefault(now+1,now+1));
                
            }
            
        }
        return answer;
    }
}
