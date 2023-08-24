import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> EDGE = new ArrayList<>();
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        //1은 light on   -1은 off
        
        for(int i=0;i<=n;i++){
            EDGE.add(new ArrayList<>());
        }
        for(int[] light:lighthouse){
            EDGE.get(light[0]).add(light[1]);
            EDGE.get(light[1]).add(light[0]);
        }
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        return dfs(1,visited).sum;
    }
    
    Light dfs(int idx, boolean[] visited){
        
        ArrayList<Integer> edge = EDGE.get(idx);
        boolean must = false;
        int sum = 0;
        for(int ed:edge){
            if(!visited[ed]){
                visited[ed] = true;
                Light light = dfs(ed,visited);
                if(light.light==-1) must = true;
                sum += light.sum;
                visited[ed] = false;
            }
        }
       
        return new Light(must?1:-1,must?sum+1:sum);
    }
}
class Light{
    
    int light, sum;
    Light(int light, int sum){
        this.light = light;
        this.sum = sum;
    }
}