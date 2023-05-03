import java.util.*;
class Solution {
    
    int MOD = 20170805;
    static int[][] CITY;
    static int[][] dp;
    static int[][] D = {{0,1},{1,0}};
    static int M,N;
    //자동차는 밑이나 오른쪽으로 이동한다
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        dp = new int[m][n];
        M=m; N=n;
        for(int i=0;i<n;i++){
            if(cityMap[0][i]==1) break;
            if(cityMap[0][i]==2) continue;
            dp[0][i] = 1;
        }
        for(int i=0;i<m;i++){
            if(cityMap[i][0]==1) break;
            if(cityMap[i][0]==2) continue;
            dp[i][0] = 1;
        }
        
        for(int i=1;i<m;i++){
            
            for(int j=1;j<n;j++){
                
                if(cityMap[i][j]==1) continue;
                if(cityMap[i][j]==2){
                    int p = i+1;
                    while(dp[i-1][j]!=0&&p<m&&cityMap[p][j]==2){
                        p++;
                    }
                    if(p<m&&cityMap[p][j]==0) dp[p][j] += dp[i-1][j];
                    int q = j+1;
                    while(dp[i][j-1]!=0&&q<n&&cityMap[i][q]==2){
                        q++;
                    }
                    if(q<n&&cityMap[i][q]==0) dp[i][q] += dp[i][j-1];
                    
                }else{
                    dp[i][j]+=dp[i-1][j] + dp[i][j-1];
                }
                dp[i][j]%= 20170805;
            }
            
        }
        
        return dp[m-1][n-1];
    }
    
}