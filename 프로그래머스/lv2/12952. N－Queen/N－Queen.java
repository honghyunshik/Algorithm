import java.util.*;
class Solution {
    
    static int[] arr;
    static int N;
    static int answer = 0;
    public int solution(int n) {
        arr = new int[n];
        N = n;
        backTraking(0);
        return answer;
    }
    
    private void backTraking(int idx){
        
        if(idx==N){
            answer++;
            return;
        }
        
        for(int i=0;i<N;i++){
            
            boolean flag = true;
            for(int j=0;j<idx;j++){
                
                if(arr[j]==i||Math.abs(idx-j)==Math.abs(i-arr[j])){
                    flag = false;
                    break;
                }       
            }
            
            if(flag) {
                arr[idx] = i;
                backTraking(idx+1);
            }
        }
        
    }
}