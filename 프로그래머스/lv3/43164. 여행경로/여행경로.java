import java.util.*;


class Solution {
    
    String[][] TICKETS;
    HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        answer = new String[tickets.length+1];
        Arrays.sort(tickets,(a,b)->{
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        TICKETS = tickets;
        for(int i=0;i<tickets.length;i++){
            
            ArrayList<Integer> list = map.getOrDefault(tickets[i][0], new ArrayList<>());
            list.add(i);
            map.put(tickets[i][0],list);
        }
        
        boolean[] visited = new boolean[tickets.length];
        String[] arr = new String[tickets.length+1];
        arr[0] = "ICN";
        for(int i=0;i<tickets.length;i++){
            
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                dfs(1,i,visited,arr);
                visited[i] = false;
            }
            
        }
        
        return answer;
    }
    
    void dfs(int num, int idx, boolean[] visited, String[] arr){
        
        if(answer[0]!=null) return;
        
        String next = TICKETS[idx][1];
        arr[num] = next;
        
        if(num==arr.length-1){
            answer = arr;
            return;
        }
        
        ArrayList<Integer> edge = map.get(next);
        if(edge==null) return;
        for(int ed:edge){
            if(!visited[ed]){
                visited[ed] = true;
                dfs(num+1,ed,visited,arr);
                visited[ed] = false;
            }
        }
        
    }
}