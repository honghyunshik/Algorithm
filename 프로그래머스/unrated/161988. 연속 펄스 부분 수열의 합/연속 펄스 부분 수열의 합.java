import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        long answer = 0;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = Math.max(0,sequence[0]);
        dp2[0] = Math.max(0,-sequence[0]);
        if(sequence.length==1) return Math.max(dp1[0],dp2[0]);
        int mul = -1;
        for(int i=1;i<sequence.length;i++){
            
            dp1[i] = Math.max(dp1[i-1] + sequence[i]*mul, 0);
            dp1[i] = Math.max(sequence[i]*mul, dp1[i]);
            answer = Math.max(dp1[i],answer);
            mul *= -1;
            dp2[i] = Math.max(dp2[i-1] + sequence[i]*mul, 0);
            dp2[i] = Math.max(sequence[i]*mul, dp2[i]);
            answer = Math.max(dp2[i],answer);
        }
        return answer;
    }
}