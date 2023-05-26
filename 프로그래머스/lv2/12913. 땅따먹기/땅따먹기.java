import java.util.*;
class Solution {
    
    
    int solution(int[][] land) {
        
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            int temp1 = 0;
            int temp2 = 0;
            int temp3 = 0;
            int temp4 = 0;
            if(i>0){
                for(int p=0;p<4;p++){
                    if(p!=0) temp1 = Math.max(temp1,dp[i-1][p]);
                    if(p!=1) temp2 = Math.max(temp2,dp[i-1][p]);
                    if(p!=2) temp3 = Math.max(temp3,dp[i-1][p]);
                    if(p!=3) temp4 = Math.max(temp4,dp[i-1][p]);
                }
            }
            dp[i][0] = land[i][0] + temp1;
            dp[i][1] = land[i][1] + temp2;
            dp[i][2] = land[i][2] + temp3;
            dp[i][3] = land[i][3] + temp4;
        }
        for(int i=0;i<4;i++){
            answer = Math.max(answer,dp[n-1][i]);
        }
        
    
        return answer;
    }
    
}