import java.util.*;
class Solution {
    
    static int[][] dp;
    static boolean[] visited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        dp = new int[n+1][n+1];
        visited = new boolean[n+1];
        int MAX = 9999999;
        for(int i=1;i<dp.length;i++){
            Arrays.fill(dp[i],MAX);
        }
        for(int[] result:results){
            int win = result[0];
            int lose = result[1];
            dp[win][lose] = 1;
            dp[lose][win] = -1;
        }
        for(int i=1;i<=n;i++){
            dp[i][i] = 0;
        }
        
        for(int i=1;i<=n;i++){
            
            ArrayList<Integer> win = new ArrayList<>();
            ArrayList<Integer> lose = new ArrayList<>();
            
            for(int j=1;j<=n;j++){
                if(dp[i][j]==1) lose.add(j);
                else if(dp[i][j]==-1) win.add(j);
            }
            if(win.size()>0&&lose.size()>0){
                
                for(int p=0;p<win.size();p++){
                    
                    for(int q=0;q<lose.size();q++){
                        
                        dp[win.get(p)][lose.get(q)] = 1;
                        dp[lose.get(q)][win.get(p)] = -1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            boolean flag = true;
            for(int j=1;j<=n;j++){
                if(dp[i][j]==MAX){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        
        
        
        return answer;
    }
}