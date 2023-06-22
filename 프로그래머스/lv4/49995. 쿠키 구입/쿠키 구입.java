import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        
        int answer = 0;
        
        for(int i=1;i<cookie.length;i++){
            
            int lIdx = i-1, rIdx = i;
            int lSum = 0, rSum = 0;
            while(lIdx>=0&&rIdx<cookie.length){
                
                if(lSum==rSum){
                    answer = Math.max(lSum,answer);
                    lSum += cookie[lIdx--];
                    rSum += cookie[rIdx++];
                }else if(lSum<rSum){
                    lSum += cookie[lIdx--];
                }else rSum += cookie[rIdx++];
            }
            while(lIdx<0&&rIdx<cookie.length&&lSum>rSum){
                rSum += cookie[rIdx++];
            }
            
            while(rIdx>=cookie.length&&lIdx>=0&&lSum<rSum){
                lSum += cookie[lIdx--];
            }
            if(lSum==rSum) answer = Math.max(answer,lSum);
            
        }
        
        return answer;
    }
}