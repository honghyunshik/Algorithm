import java.util.*;

class Solution {
    
    //언제 수정해야 하는가?
    //다음 경로로 이동할 수 없을때
    ArrayList<ArrayList<Integer>> edge;
    int[][] dis;
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edge.add(new ArrayList<>());
        }
        for(int[] ed:edge_list){
            int l = ed[0];
            int r = ed[1];
            edge.get(l).add(r);
            edge.get(r).add(l);
        }
        int INF = 9999999;
        int[][] dp = new int[k][n+1];
        for(int i=0;i<k;i++){
            Arrays.fill(dp[i],INF);
        }
        dp[0][gps_log[0]] = 0;
        for(int i=1;i<k;i++){
            int now = gps_log[i];
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]);
                for(int idx=0;idx<edge.get(j).size();idx++){
                    int back = edge.get(j).get(idx);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][back]);
                }
                if(j!=now) dp[i][j]++;
            }
            
        }
        
        if(dp[k-1][gps_log[k-1]]<INF) return dp[k-1][gps_log[k-1]];
        
        
        
        
        return -1;
    }
}