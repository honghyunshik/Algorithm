import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i=0;i<computers.length;i++){
            //System.out.println(Arrays.toString(visited));
            if(!visited[i]){
                answer++;
                dfs(computers,i);
            }
            
        }
        return answer;
    }
    void dfs(int[][] computers, int idx){
        
        for(int i=0;i<computers[idx].length;i++){
            //방문하지 않았다면
            if(!visited[i]&&computers[idx][i]==1){
                visited[i] = true;
                dfs(computers,i);
            }
        }
    }
}