import java.util.*;

class Solution {
    
    static int[] STONES;
    
    public int solution(int[] stones, int k) {
        
        STONES = stones;
        int l = 0, r = 0;
        for(int i=0;i<stones.length;i++){
            r = Math.max(r,stones[i]);
        }
        
        while(l<r){
            
            int mid = (l+r)/2;
            if(canGo(mid,k)) l = mid+1;
            else r = mid;
        }
        
        return l;
    }
    
    boolean canGo(int minus, int k){
        
        int stack = 0;
        for(int i=0;i<STONES.length;i++){
            
            if(STONES[i]>minus) stack = 0;
            else stack++;
            if(stack>=k) return false;
            
        }
        
        return true;
    }
}