import java.util.*;
class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i=0;i<size;i++){
            
            char now = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek()==now){
                stack.pop();
            }else{
                stack.add(now);
            }
        }
        if(stack.size()>0) return 0;
        return 1;
    }
}