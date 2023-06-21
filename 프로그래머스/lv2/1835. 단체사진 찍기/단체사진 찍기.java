import java.util.*;

class Solution {
    
    int answer = 0;
    String[] DATA;
    char[] name = {'A','C','F','J','M','N','R','T'};
    public int solution(int n, String[] data) {
        
        boolean[] visited = new boolean[8];
        char[] arr = new char[8];
        DATA = data;
        dfs(0,visited,arr);
        return answer;
    }
    
    private void dfs(int idx, boolean[] visited, char[] arr){
        
        if(idx==8){
            answer += check(arr);
            return;
        }
        for(int i=0;i<8;i++){
            
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = name[i];
                dfs(idx+1,visited,arr);
                visited[i] = false;
            }
        }
    }
   
    
    private int check(char[] arr){
        
        for(String data:DATA){
            
            char l = data.charAt(0);
            char r = data.charAt(2);
            char sign = data.charAt(3);
            int num = data.charAt(4)-'0';
            int lIdx = -1, rIdx = -1;
            for(int i=0;i<8;i++){
                if(arr[i]==l) lIdx = i;
                if(arr[i]==r) rIdx = i;
            }
           
            int dif = Math.abs(lIdx-rIdx);
            if(sign=='='){
                if(dif!=num+1) return 0;
            }else if(sign=='>'){
                if(dif<=num+1) return 0;
            }else if(sign=='<'){
                if(dif>=num+1) return 0;
            }
            
        }
        return 1;
    }
}