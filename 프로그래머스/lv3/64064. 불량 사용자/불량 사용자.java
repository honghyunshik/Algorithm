import java.util.*;

class Solution {
    
    static HashMap<String,ArrayList<String>> map;
    static HashSet<HashSet<String>> SET;
    static String[] BANNED;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        map = new HashMap<>();
        for(String s:user_id){
            makeMap(s,"",0);
        }
        SET = new HashSet<>();
        
        BANNED = banned_id;
        
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        dfs(0,set);
        
        
        return SET.size();
    }
    
    private void dfs(int idx, HashSet<String> set){
        
        if(idx==BANNED.length){
            SET.add(new HashSet<>(set));
            
            return;
        }
        ArrayList<String> list = map.get(BANNED[idx]);
        for(int i=0;i<list.size();i++){
            
            if(!set.contains(list.get(i))){
                set.add(list.get(i));
                dfs(idx+1,set);
                set.remove(list.get(i));
            }
        }
    }
    
    private void makeMap(String total, String sum, int idx){
        
        if(idx==total.length()){
            
            ArrayList<String> list = map.get(sum);
            if(list==null) list = new ArrayList<>();
            list.add(total);
            map.put(sum,list);
            return;
        }
        makeMap(total,sum+total.charAt(idx),idx+1);
        makeMap(total,sum+"*",idx+1);
        
    }
}