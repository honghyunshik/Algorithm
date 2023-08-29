import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[][] cnt = new int[e+1][2];
        for(int i=1;i<=e;i++){
            
            cnt[i][0] = i;
            for(int j=1;j<=e;j++){
                
                if(i*j>e) break;
                cnt[i*j][1]++;
            }
        }
        Arrays.sort(cnt,(a,b)->{
            if(b[1]==a[1]) return a[0]-b[0];
            return b[1]-a[1];
        });
    
        
        for(int start=0;start<starts.length;start++){
            
            for(int i=0;i<cnt.length;i++){
            
                if(cnt[i][0]>=starts[start]) {
                    answer[start] = cnt[i][0];
                    break;
                }
            }    
        }
        
        
        return answer;
    }
}
