import java.util.*;

class Solution {
    int[][] TARGET;
    int[][] temp;
    int N,M;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        
        N = beginning.length;
        M = beginning[0].length;
        TARGET = new int[N][M];
        temp = new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(beginning[i][j]==target[i][j]) TARGET[i][j] = 0;
                else TARGET[i][j] = 1;
            }
        }
        
        force(-1,0);
        if(answer==Integer.MAX_VALUE) return -1;
        
        
        return answer;
    }
    
    private void force(int rowIdx,  int cnt){
           
        int check = check();
        if(check>=0){
            answer = Math.min(answer,cnt + check);
            return;
        }
        
        
        for(int i=rowIdx+1;i<M;i++){
            
            for(int j=0;j<N;j++){
                temp[j][i]++;
            }
            force(i,cnt+1);
            for(int j=0;j<N;j++){
                temp[j][i]++;
            }
        }
        
    }
    
    private int check(){
        
        boolean flag = true;
        int ans = 0;
        for(int i=0;i<N;i++){
            boolean tempFlag = (temp[i][0]%2==TARGET[i][0]);
            
            for(int j=0;j<M;j++){
                if(tempFlag!=(temp[i][j]%2==TARGET[i][j])) return -1;
            }
            if(temp[i][0]%2!=TARGET[i][0]) ans++;
        }
        return ans;
    }
}

