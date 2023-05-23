import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];

        for(int i=0;i<words.length;i++){
            
            String word = words[i];
            if(i>0&&words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                return new int[]{i%n+1,i/n+1};
                
            }
            if(set.contains(word)) return new int[]{i%n+1,i/n+1};
               
            set.add(word);
        }
        
        return new int[]{0,0};
    }
}