import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int sc:scoville){
            pq.add(sc);
        }
        
        int l = -1;
        int r = -1;
        
        while(!pq.isEmpty()&&l<K&&r<K){
            
            if(l==-1) l = pq.poll();
            else if(r==-1){
                answer++;
                r = pq.poll();
                pq.add(l+r*2);
                if(pq.peek()<K){
                    l = -1;
                    r = -1;
                }else break;
            }
        }
        if(pq.isEmpty()) return -1;
        return answer;
    }
}