import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        
        for(int i=0;i<keymap.length;i++){
            
            for(int j=0;j<keymap[i].length();j++){
                
                char now = keymap[i].charAt(j);
                map.put(now,Math.min(map.getOrDefault(now,j+1),j+1));
            }
        }
        for(int i=0;i<targets.length;i++){
            int score = 0;
            for(int j=0;j<targets[i].length();j++){
                char now = targets[i].charAt(j);
                if(map.get(now)==null){
                    score = -1;
                    break;
                }else{
                    score += map.get(now);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}