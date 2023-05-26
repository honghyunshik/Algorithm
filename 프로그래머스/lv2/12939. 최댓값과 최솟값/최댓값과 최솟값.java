import java.util.*;
class Solution {
    public String solution(String s) {
        
        String[] li = s.split(" ");
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String str:li){
            
            int num = 0;
            int temp = 1;
            for(int i=str.length()-1;i>=0;i--){
                
                if(str.charAt(i)=='-') num = -num;
                else{
                    num += (str.charAt(i)-48)*temp;
                    temp *= 10;
                }
            }
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        
       
        return min + " " + max;
    }
}