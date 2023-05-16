import java.util.*;
class Solution {
    
    static long[] longA;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static long answer = 0;
    
    public long solution(int[] a, int[][] edges) {
        
        int can = 0;
        longA = new long[a.length];
        for(int i=0;i<a.length;i++){
            can+=a[i];
            longA[i] = a[i];
        }
        if(can!=0) return -1;
        
        list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int l = edge[0];
            int r = edge[1];
            list.get(l).add(r);
            list.get(r).add(l);
        }
        visited = new boolean[a.length];
        dfs(list.get(0).get(0),0);
        return answer;
    }
    
    void dfs(int idx, int parentIdx){
        
        for(int i=0;i<list.get(idx).size();i++){
            
            int next = list.get(idx).get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next, idx);
            } 
        }
        answer += longA[idx]>0?longA[idx]:-longA[idx];
        longA[parentIdx] += longA[idx];
        longA[idx] = 0;
    }
}
