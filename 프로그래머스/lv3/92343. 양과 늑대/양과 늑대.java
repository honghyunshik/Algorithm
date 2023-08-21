import java.util.*;
class Solution {
    
    static ArrayList<ArrayList<Integer>> list;
    static int answer = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {
        
        
        list = new ArrayList<>();
        for(int i=0;i<info.length;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        int size = info.length;
        boolean[][][] visited = new boolean[size][size+1][size+1];
        dfs(0,0,0,info,visited);
        
        return answer;
    }
    
    void dfs(int idx,int sheep, int wolf, int[] info, boolean[][][] visited){
        
        if(info[idx]==0) sheep++;
        else if(info[idx]==1) wolf++;
        
        if(wolf>=sheep) return;
        answer = Math.max(answer,sheep);
        
        for(int i=0;i<list.get(idx).size();i++){
            
            if(!visited[idx][sheep][wolf]){
                visited[idx][sheep][wolf] = true;
                int temp = info[idx];
                int nextIdx = list.get(idx).get(i);
                info[idx] = -1;
                dfs(nextIdx,sheep,wolf,info,visited);
                info[idx] = temp;
                visited[idx][sheep][wolf] = false;
            }
            
        }
        
    }
}