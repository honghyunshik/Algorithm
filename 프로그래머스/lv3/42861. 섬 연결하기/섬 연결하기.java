import java.util.*;

class Solution {
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        boolean[] visited = new boolean[n];
        visited[costs[0][0]] = true;
        visited[costs[0][1]] = true;
        int answer = costs[0][2];
        int cnt = 2;
        while(cnt<n){
            for(int i=1;i<costs.length;i++){
                int l = costs[i][0];
                int r = costs[i][1];
                if(visited[l]!=visited[r]){
                    visited[l] = true;
                    visited[r] = true;
                    answer += costs[i][2];
                    cnt++;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}