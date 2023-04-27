import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String,Integer> map =new HashMap<>();
        int idx = 0;
        for(String na:name){
            map.put(na,yearning[idx++]);
        }
        int[] answer = new int[photo.length];
        
        for(int i=0;i<photo.length;i++){
            
            int score = 0;
            for(int j=0;j<photo[i].length;j++){
                if(map.containsKey(photo[i][j])) score += map.get(photo[i][j]);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}