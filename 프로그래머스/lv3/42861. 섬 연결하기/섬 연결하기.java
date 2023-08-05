import java.util.*;
class Solution {
    //다익스트라는 한점에서 다른 점들로 가는 최소거리를 찾는 알고리즘이다
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        boolean[] visited = new boolean[n];
        visited[costs[0][0]] = true;
        visited[costs[0][1]] = true;
        answer += costs[0][2];
        int k = 2;
        while(k<n){
            for(int i=1;i<costs.length;i++){
                if(visited[costs[i][0]]^visited[costs[i][1]]){
                    visited[costs[i][0]] = true;
                    visited[costs[i][1]] = true;
                    k++;
                    answer+=costs[i][2];
                    break;
                }
            }
        }
        
        return answer;
    }
}