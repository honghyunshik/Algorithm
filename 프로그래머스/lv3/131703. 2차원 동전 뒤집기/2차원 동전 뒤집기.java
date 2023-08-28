import java.util.*;

class Solution {
    
    int[][] TARGET;
    int N,M;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        
        N = target.length;
        M = target[0].length;
        TARGET = new int[N][M];
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(beginning[i][j]!=target[i][j]) TARGET[i][j] = 1;
            }
        }
       
        dfs(0,new int[N],0);
        if(answer==Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    
    
    void dfs(int idx, int[] row, int cnt){
        
        if(idx==N){
            
            int temp = fit(row);
            
            if(temp!=-1){
                answer = Math.min(answer,temp+cnt); 
            }
            return;
        }
        
        
        dfs(idx+1,row,cnt);
        row[idx]++;
        dfs(idx+1,row,cnt+1);
        row[idx]--;
    }
    
    int fit(int[] row){
        
        int ans = 0;
        int[] col = new int[M];
        for(int i=0;i<M;i++){
            if(TARGET[0][i]!=row[0]) {
                col[i] = 1;
                ans++;
            }
        }
        
        
        for(int i=0;i<N;i++){
            
            for(int j=0;j<M;j++){
                
                if((row[i]+col[j])%2!=TARGET[i][j]) {
                    
                    return -1;
                }
                
            }
        }
       
        return ans;
        
    }
}