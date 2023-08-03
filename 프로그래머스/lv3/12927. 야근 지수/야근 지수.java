import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++){
            int num = pq.poll();
            if(num==0) break;
            pq.add(num-1);
        }
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num*num;
        }
        return answer;
    }
}