import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[Math.max(61,target+1)][2];
        int MAX = 9999999;
        for(int i=1;i<dp.length;i++){
            dp[i][0] = MAX;
        }
        for(int i=1;i<=20;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            dp[i*2][0] = 1;
            dp[i*3][0] = 1;
        }
        dp[50][0] = 1;
        dp[50][1] = 1;
        
        for(int i=21;i<=target;i++){
            
            for(int j=Math.max(1,i/2-60);j<=i/2;j++){
                
                if(dp[i][0]>dp[j][0] + dp[i-j][0]||(dp[i][0]==dp[j][0]+dp[i-j][0]&&dp[i][1]<dp[j][1]+dp[i-j][1])){
                    dp[i][0] = dp[j][0] + dp[i-j][0];
                    dp[i][1] = dp[j][1] + dp[i-j][1];
                }
            }
        }
 
        
        return new int[]{dp[target][0],dp[target][1]};
    }
}