import java.util.*;

class Solution {
    
    HashMap<Long,Long> map = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        HashSet<Long> set = new HashSet<>();
        
        for(int i=0;i<room_number.length;i++){
            
            //없을경우 방 배정
            if(!set.contains(room_number[i])){
                set.add(room_number[i]);
                answer[i] = room_number[i];
                map.put(room_number[i],map.getOrDefault(room_number[i]+1,find(room_number[i]+1)));
            }
            //있을경우 
            else{
                Long now = find(room_number[i]);
                answer[i] = now;
                set.add(now);
                map.put(now,map.getOrDefault(now+1,find(now+1)));
                
            }
            
        }
        return answer;
    }
    
    //부모 찾기
    long find(Long num){
        
        Long now = map.getOrDefault(num,num);
        Long back = num;
        while(map.get(now)!=null){
            Long temp = now;
            now = map.get(now);
            map.put(back,now);
            back = temp;
        }
        return now;
    }
}