import java.util.*;
class Solution {
    
    ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    int[] INFO;
    
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        
        //전역변수로 생성
        INFO = info;
        
        //edge ArrayList 생성
        for(int i=0;i<info.length;i++){
            edge.add(new ArrayList<>());
        }
        for(int[] ed:edges){
            edge.get(ed[0]).add(ed[1]);
        }
        
        dfs(0,new ArrayList<>(),0,0);
        
        return answer;
    }
    
    void dfs(int idx, ArrayList<Integer> child, int sheep, int wolf){
        
        //양이면 sheep +
        if(INFO[idx]==0) sheep++;
        else wolf++;
        //늑대가 더 많으면 안됨
        if(sheep<=wolf) return;
        
        answer = Math.max(answer,sheep);
        
        ArrayList<Integer> newChild = new ArrayList<>(child);
        ArrayList<Integer> nowChild = edge.get(idx);
        newChild.addAll(nowChild);
        int size = newChild.size();
        for(int i=0;i<size;i++){
            int nowVal = newChild.get(0);
            newChild.remove(Integer.valueOf(nowVal));
            dfs(nowVal,newChild,sheep,wolf);
            newChild.add(nowVal);
        }
    }
}