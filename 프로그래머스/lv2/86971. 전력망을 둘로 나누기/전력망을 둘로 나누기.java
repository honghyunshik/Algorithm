import java.util.*;
class Solution {
    
    int[][] WIRES;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        WIRES = new int[n+1][n+1];
        for(int[] wire:wires){
            int l = wire[0];
            int r = wire[1];
            WIRES[l][r] = 1;
            WIRES[r][l] = 1;
        }
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=n;j++){
                
                if(WIRES[i][j]==1){
                    
                    WIRES[i][j] = 0;
                    WIRES[j][i] = 0;
                    boolean[] visited = new boolean[n+1];
                    int left = 0;
                    int right = 0;
                    for(int k=1;k<=n;k++){
                        
                        if(!visited[k]){
                            visited[k] = true;
                            
                            if(left==0) left = dfs(k,visited);
                            else right = dfs(k,visited);
                            
                            
                        }
                    }
                    answer = Math.min(answer,Math.abs(left-right));
                    WIRES[i][j] = 1;
                    WIRES[j][i] = 1;
                }
            }
        }
        return answer;
    }
    private int dfs(int n, boolean[] visited){
        
        int sum = 0;
        for(int i=1;i<visited.length;i++){
            
            if(!visited[i]&&WIRES[i][n]==1){
                visited[i] = true;
                sum += dfs(i,visited)+1;
            }
        }
        return sum;
    }
}