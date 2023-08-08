import java.util.*;
class Solution {
    static String[] answer;
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        String[] ans = new String[tickets.length+1];
        answer = new String[tickets.length+1];
        ans[0] = "ICN";
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                ans[1] = tickets[i][1];
                dfs(tickets,visited,tickets[i][1],2,ans);    
                visited[i] = false;
            }
        }
        return answer;
    }
    
    void dfs(String[][] tickets, boolean[] visited,String start,int idx, String[] ans){
        //System.out.println(Arrays.toString(ans) + " " + idx + " " + ans.length);
        if(idx==ans.length){
            
            boolean flag = false;
            if(answer[0]==null) flag = true;
            else{
                for(int i=0;i<ans.length;i++){
                if(ans[i].compareTo(answer[i])<0){
                    flag = true;
                    break;
                }else if(ans[i].compareTo(answer[i])>0) break;
                }   
            }
            if(flag){
                for(int i=0;i<ans.length;i++){
                    answer[i] = ans[i];
                }
            }
             
            
            
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(start)&&!visited[i]){
                visited[i] = true;
                ans[idx] = tickets[i][1];
                dfs(tickets,visited,tickets[i][1],idx+1,ans);
                visited[i] = false;
            }
        }
        
        
        
    }
}