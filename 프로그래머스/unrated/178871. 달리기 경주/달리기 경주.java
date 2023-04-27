import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        for(String call:callings){
            
            int idx = map.get(call);
            map.put(players[idx-1],idx);
            map.put(players[idx],idx-1);
            swap(idx-1,idx,players);  
        }
        
        return players;
    }
    
    private void swap(int i, int j, String[] arr){
        
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}