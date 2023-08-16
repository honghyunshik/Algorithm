import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        int answer = 0;
        int[] count = new int[a.length];
        for(int i=0;i<a.length;i++){
            count[a[i]]++;
        }
        
        for(int i=0;i<a.length;i++){
            
            if(count[i]==0) continue;
            if(answer>=count[i]) continue;
            
            int sum = 0;
            for(int j=0;j<a.length-1;j++){
                
                if(a[j]!=i&&a[j+1]!=i) continue;
                if(a[j]==a[j+1]) continue;
                sum++;
                j++;
            }
            answer = Math.max(sum,answer);
            
        }
        
   
        return answer*2;
    }
}