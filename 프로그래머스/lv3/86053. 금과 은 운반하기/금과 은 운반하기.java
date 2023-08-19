import java.util.*;
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long l = 0;
        //최대 걸리는 시간은 (a+b)/(용량/걸리는시간*2)
        long r = (long)Math.pow(10,14)*4;
        
        //upper bound
        while(l<r){
            
            long mid = (l+r)/2;
            int gold = 0;
            int silver = 0;
            int plus = 0;
            
            for(int i=0;i<g.length;i++){
                
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                int nowTime = t[i];
                
                long cnt = mid/nowTime/2;
                if(mid%(nowTime*2)>=t[i]) cnt++;
                
                gold += Math.min(nowGold,nowWeight*cnt);
                silver += Math.min(nowSilver,nowWeight*cnt);
                plus += Math.min(nowGold+nowSilver,nowWeight*cnt);

            }
          
            if(a<=gold&&b<=silver&&a+b<=plus){
                r = mid;
            }else{
                l = mid+1;
            }
            
            
        }
        
        return r;
    }
}