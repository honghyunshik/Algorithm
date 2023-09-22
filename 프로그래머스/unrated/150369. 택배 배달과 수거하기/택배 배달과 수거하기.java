import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long answer = 0;
        int goMax = n-1;
        int backMax = n-1;
        
        while(true){
            
            int maxGo = deliver(deliveries,cap, goMax);
            int maxBack = deliver(pickups,cap, backMax);
            
            int plus = Math.max(maxGo,maxBack);
          
            if(plus==0) break;
            answer += plus*2;
            
            goMax = maxGo-1;
            backMax = maxBack-1;
            
            
        }
        return answer;
    }
    
    int deliver(int[] arr, int cap, int idx){
        
        int max = 0;
        for(int i=idx;i>=0;i--){
            if(cap==0) break;
            
            int minus = Math.min(cap,arr[i]);
            if(minus>0) max = Math.max(max,i+1);
            arr[i] -= minus;
            cap -= minus;
        }
        
        return max;
    }
}