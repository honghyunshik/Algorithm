import java.util.*;

class Solution {
    
    
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n,1,3);
        int[][] answer = new int[list.size()][2];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void hanoi(int n, int from, int to){
        
        if(n==1) {
            list.add(new int[]{from,to});
            return;
        }
        
        int last = 1;
        if((from==1||from==3)&&(to==1||to==3)) last = 2;
        else if((from==1||from==2)&&(to==1||to==2)) last = 3;
        
        hanoi(n-1,from,last);
        list.add(new int[]{from,to});
        hanoi(n-1,last,to);
        
    }
}