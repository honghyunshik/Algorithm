import java.util.*;

class Solution {
    
    int[][] FARE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        FARE = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            Arrays.fill(FARE[i],Integer.MAX_VALUE);
            FARE[i][i] = 0;
        }
        
        for(int[] fare:fares){
            int start = fare[0];
            int end = fare[1];
            int dis = fare[2];
            FARE[start][end] = dis;
            FARE[end][start] = dis;
        }
        
        
        for(int mid=1;mid<=n;mid++){
            
            for(int start=1;start<=n;start++){
                
                for(int end=1;end<=n;end++){
                    
                    if(FARE[start][mid]==Integer.MAX_VALUE||FARE[mid][end]==Integer.MAX_VALUE) continue;
                    FARE[start][end] = Math.min(FARE[start][end],FARE[start][mid] + FARE[mid][end]);
                }
            }
        }
     
        
        for(int mid=1;mid<=n;mid++){
            if(FARE[s][mid]==Integer.MAX_VALUE||FARE[mid][a]==Integer.MAX_VALUE||FARE[mid][b]==Integer.MAX_VALUE) continue;
            answer = Math.min(answer,FARE[s][mid] + FARE[mid][a] + FARE[mid][b]);
        }
        
        
        return answer;
    }
}