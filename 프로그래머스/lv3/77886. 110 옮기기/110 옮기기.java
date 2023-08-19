import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        
        for(int b=0;b<s.length;b++){
            
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            for(int i=0;i<s[b].length();i++){
                
                char z = s[b].charAt(i);
                if(stack.size()>1){
                    
                    char y = stack.pop();
                    char x = stack.pop();
                    if(x=='1'&&y=='1'&&z=='0'){
                        cnt++;
                    }else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }else stack.push(z);
            }
            
            
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                char now = stack.pop();
                if(cnt>0&&now=='0'){
                    for(int j=0;j<cnt;j++){
                        sb.insert(0,"110");
                    }
                    cnt = 0;
                }
                sb.insert(0,now);
            }
            if(cnt>0){
                for(int j=0;j<cnt;j++){
                    sb.insert(0,"110");
                }
            }
            answer[b] = sb.toString();
            
        }
        return answer;
    }
}