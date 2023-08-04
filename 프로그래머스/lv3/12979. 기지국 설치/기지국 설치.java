import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        

        int answer = 0;
        int now = 1;
        int len = w*2+1;
        for(int i=0;i<stations.length;i++){
         
            int back = stations[i]-w;
            if(back>now){
                answer += (back-now)%len==0?(back-now)/len:((back-now)/len)+1;
            }
            now = stations[i]+w+1;           
        }
        if(now<=n){
            answer += (n-now+1)%len==0?(n-now+1)/len:((n-now+1)/len)+1;
        }
        
        return answer;
    }
}