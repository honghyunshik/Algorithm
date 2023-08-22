import java.util.*;

class Solution {
    int[][] dp;
    int N=0,M=0;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int MAX = 999999;
        
        for(int[] problem:problems){
            N = Math.max(N,problem[0]);
            M = Math.max(M,problem[1]);
        }
        if(alp>=N&&cop>=M) return 0;
        alp = Math.min(alp,N);
        cop = Math.min(cop,M);
        dp = new int[N+1][M+1];
        for(int i=alp;i<=N;i++){
            Arrays.fill(dp[i],MAX);
        }
        dp[alp][cop] = 0;
        for(int i=alp;i<=N;i++){
            
            for(int j=cop;j<=M;j++){
                
                dp[Math.min(i+1,N)][j] = Math.min(dp[Math.min(i+1,N)][j],dp[i][j]+1);
                dp[i][Math.min(j+1,M)] = Math.min(dp[i][Math.min(j+1,M)],dp[i][j]+1);
                
                for(int[] problem:problems){
                    
                    if(i>=problem[0]&&j>=problem[1]){
                        dp[Math.min(i+problem[2],N)][Math.min(j+problem[3],M)] = Math.min(dp[Math.min(i+problem[2],N)][Math.min(j+problem[3],M)], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        return dp[N][M];
    }
}