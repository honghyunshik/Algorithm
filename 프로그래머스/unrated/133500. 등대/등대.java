import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> list;
    int answer = 0;
    //리프노드를 찾고 
    public int solution(int n, int[][] lighthouse) {
        
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] light:lighthouse){
            int l = light[0];
            int r = light[1];
            list.get(l).add(r);
            list.get(r).add(l);
        }
        dfs(1,0);
        return answer;
    }
    
    //0은 불이 꺼져있는 것이고 1은 불이 켜져있는 것
    private int dfs(int now, int before){
        
        if(list.get(now).size()==1&&list.get(now).get(0)==before) return 1;
        
        int sum = 0;
        for(int i=0;i<list.get(now).size();i++){
            
            int next = list.get(now).get(i);
            if(next==before) continue;
            sum += dfs(next,now);
        }
        
        if(sum==0) {
           
            return 1;
        }
        
         answer++;
         return 0;
        
    }
}