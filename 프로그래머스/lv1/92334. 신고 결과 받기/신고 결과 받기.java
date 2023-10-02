import java.util.*;

class Solution {
    HashMap<String,HashSet<String>> map = new HashMap<>();
    HashMap<String,Integer> idxMap = new HashMap<>();
    
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(int idx=0;idx<id_list.length;idx++){
            idxMap.put(id_list[idx],idx);
            map.put(id_list[idx],new HashSet<>());
        }
        HashSet<String> temp = new HashSet<>();
        for(String re:report){
            String to = re.split(" ")[0];
            String from = re.split(" ")[1];
            HashSet<String> set = map.get(from);
            set.add(to);
            if(set.size()>=k){
                temp.add(from);
            }
            map.put(from,set);
        }
        for(String li:temp){
            
            HashSet<String> set = map.get(li);
            for(String s:set){
                answer[idxMap.get(s)]++;
            }
        }
        return answer;
    }
}