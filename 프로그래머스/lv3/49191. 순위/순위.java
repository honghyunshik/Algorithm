import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
         for(int[] result:results){
            
            int win = result[0];
            int lose = result[1];
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=n;j++){
                
                //i가 j를 이겼다 --> j가 이긴 애들은 다 이김
                //i가 j한테 졌다 --> j가 진 애들한테 다 짐
                if(arr[i][j]==1||arr[i][j]==-1){
                    
                    for(int t=1;t<=n;t++){
                        
                        if(arr[j][t]==arr[i][j]) arr[i][t] = arr[i][j];
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=n;j++){
                
                //i가 j를 이겼다 --> j가 이긴 애들은 다 이김
                //i가 j한테 졌다 --> j가 진 애들한테 다 짐
                if(arr[i][j]==1||arr[i][j]==-1){
                    
                    for(int t=1;t<=n;t++){
                        
                        if(arr[j][t]==arr[i][j]) arr[i][t] = arr[i][j];
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=n;j++){
                
                if(i!=j&&arr[i][j]==0) break;
                if(j==n) answer++;
            }
        }
        return answer;
    }
}