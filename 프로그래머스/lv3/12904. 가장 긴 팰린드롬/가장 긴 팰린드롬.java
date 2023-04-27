import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i=0;i<s.length();i++){
            
            int l  =i-1;
            int r = i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                answer = Math.max(r-l+1,answer);
                l--;
                r++;
            }
            l = i-1;
            r = i+1;
            
            if(i+2<s.length()&&s.charAt(i)==s.charAt(i+1)){
                answer = Math.max(answer,2);
                r++;
                while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                    answer = Math.max(r-l+1,answer);
                    l--;
                    r++;
                }
            }
            
        }

        return answer;
    }
}