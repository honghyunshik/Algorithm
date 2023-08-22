
import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        int answer = 0;
        int maxAlp = Integer.MIN_VALUE;
        int maxCop = Integer.MIN_VALUE;
        
        for(int i=0;i<problems.length;i++){
            maxAlp = Math.max(problems[i][0],maxAlp);
            maxCop = Math.max(problems[i][1],maxCop);
        }
        if(maxAlp<=alp&&maxCop<=cop) return 0;
        alp = Math.min(alp,maxAlp);
        cop = Math.min(cop,maxCop);
        int[][] dp = new int[maxAlp+2][maxCop+2];
        
        for(int i=alp;i<=maxAlp;i++){
            for(int j=cop;j<=maxCop;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp;i<=maxAlp;i++){
            for(int j=cop;j<=maxCop;j++){
                
                //알고리즘 공부
                dp[i+1][j] = Math.min(dp[i][j]+1,dp[i+1][j]);
                //코딩력 공부
                dp[i][j+1] = Math.min(dp[i][j]+1,dp[i][j+1]);
                
                for(int[] problem:problems){
                    //문제를 풀 수 있을 경우
                    if(problem[0]<=i&&problem[1]<=j){
                        int nextI = Math.min(i + problem[2],maxAlp);
                        int nextJ = Math.min(j + problem[3],maxCop);
                        dp[nextI][nextJ] = Math.min(dp[nextI][nextJ],dp[i][j]+problem[4]);
                    } 
                } 
            }
        }
        
        
        
        return dp[maxAlp][maxCop];
    }
}