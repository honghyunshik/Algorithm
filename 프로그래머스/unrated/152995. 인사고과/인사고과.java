import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int answer = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        
        int sum = scores[0][0] + scores[0][1];
        for(int[] score:scores){
            pq.add(score);
         }
        
        int backL = Integer.MAX_VALUE;
        int backMaxR = 0;
        int nowMaxR = 0;
        
        while(!pq.isEmpty()){
            
            int[] score = pq.poll();
            if(backL>score[0]){
                backMaxR = Math.max(backMaxR,nowMaxR);
                nowMaxR = 0;
            }
            nowMaxR = Math.max(nowMaxR,score[1]);

            if(backMaxR<=score[1]){
                //원호보다 높다면 등수 높임
                if(score[0]+score[1]>sum) answer++;
            }else if(score[0]==scores[0][0]&&score[1]==scores[0][1]) return -1;
        }
        
        return answer;
    }
}