class Solution {
    
    int MOD = 20170805;
    int[][] CITYMAP;
    int[][][] dp;
    int M,N;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        CITYMAP = cityMap;
        M = m;
        N = n;
        //0은 ->  1은 아래
        dp = new int[M][N][2];
        
        //맨 위
        for(int i=1;i<N;i++){
            if(CITYMAP[0][i]==1) break;
            dp[0][i][0] = 1;
            if(CITYMAP[0][i]==0) dp[0][i][1] = 1;
        }
        
        //맨 왼쪽
        for(int i=1;i<M;i++){
            if(CITYMAP[i][0]==1) break;
            dp[i][0][1] = 1;
            if(CITYMAP[i][0]==0) dp[i][0][0] = 1;
        }
        
        for(int i=1;i<M;i++){
            
            for(int j=1;j<N;j++){
                
                if(CITYMAP[i][j]==1) continue;
                else if(CITYMAP[i][j]==2){
                    dp[i][j][0] += dp[i][j-1][0];
                    dp[i][j][1] += dp[i-1][j][1];
                }else{
                    dp[i][j][0] += dp[i-1][j][1] + dp[i][j-1][0];
                    dp[i][j][1] += dp[i-1][j][1] + dp[i][j-1][0];
                }
                dp[i][j][0] %= MOD;
                dp[i][j][1] %= MOD;
            }
        }
        
        
        return (dp[M-1][N-2][0] + dp[M-2][N-1][1])%MOD;
    }
}