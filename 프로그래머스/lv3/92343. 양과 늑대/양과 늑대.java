import java.util.*;

class Solution {
    int answer = 0;
    int[] INFO;
    ArrayList<ArrayList<Integer>> EDGES = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {
        
        INFO = info;
        for(int i=0;i<info.length;i++){
            EDGES.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int l = edge[0];
            int r = edge[1];
            EDGES.get(l).add(r);
   
        }
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        dfs(0,0,0,new ArrayList<>(),visited);
        return answer;
    }
    
    void dfs(int idx, int sheep, int wolf, ArrayList<Integer> list, boolean[] visited){
        
        if(INFO[idx]==0) sheep++;
        else wolf++;
        if(sheep<=wolf) return;
        answer = Math.max(answer,sheep);
        
        
        ArrayList<Integer> child = EDGES.get(idx);
        ArrayList<Integer> newList = new ArrayList<>();
        newList.addAll(child);
        newList.addAll(list);
         newList.remove(Integer.valueOf(idx));
        for(int i=0;i<newList.size();i++){
            int next = newList.get(i);
            if(next!=idx&&!visited[next]){
                visited[next] = true;
                dfs(next,sheep,wolf,newList,visited);
                visited[next] = false;
            }
           
        }
    }
}