import java.util.*;

class Solution {
    
    
    public int solution(String[] strs, String t) {
        
        int[] dp = new int[t.length()+1];
        int MAX = 999999;
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        
        //b ba ban bana banan banana
        for(int len=1;len<=t.length();len++){
            
            for(String str:strs){
                
                if(len<str.length()) continue;
                if(t.substring(len-str.length(),len).equals(str)){     
                    dp[len] = Math.min(dp[len],dp[len-str.length()]+1);
                }
            }
        }
        
        return dp[t.length()]==MAX?-1:dp[t.length()];
    }
}