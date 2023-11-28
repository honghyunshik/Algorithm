import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String new_id) {
        new_id = toLower(new_id);
        new_id = replace(new_id);
        new_id = deleteContinuousDot(new_id);
        new_id = deleteFrontLast(new_id);
        new_id = ifBlank(new_id);
        new_id = isOver16(new_id);
        new_id = isUnder2(new_id);
        return new_id;
    }
    
    //1단계
    private String toLower(String str){
        return str.toLowerCase();
    }
    
    //2단계
    private String replace(String str){
        
        Set<Character> set = new HashSet<>();
        
        str.chars()                           
            .mapToObj(c -> (char) c)                   
            .filter(c -> !isValidChar(c))              
            .forEach(set::add);  
        
        
        for(char c:set){
            str = str.replace(c+"","");
        }
        
        return str;
    }
    
    //3단계
    private String deleteContinuousDot(String str){
        
        for(int i=str.length()-1;i>=2;i--){
            String dot = makeDot(i);
            str = str.replace(dot,".");
        }
        return str;
    }
    
    //4단계
    private String deleteFrontLast(String str){
        if(str.charAt(0)=='.') str = str.substring(1,str.length());
        if(str.length()>0&&str.charAt(str.length()-1)=='.') str = str.substring(0,str.length()-1);
        return str;
    }
    
    //5단계
    private String ifBlank(String str){
        if(str.length()==0) return "a";
        return str;
    }
    
    //6단계
    private String isOver16(String str){
        if(str.length()>=16){
            if(str.charAt(14)=='.') return str.substring(0,14);
            return str.substring(0,15);
            
        }
        return str;
    }
    
    //7단계
    private String isUnder2(String str){
        if(str.length()<=2){
            char last = str.charAt(str.length()-1);
            while(str.length()<=2){
                str = str + last;
            }
        }
        return str;
    }
    
    private String makeDot(int num){
        
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,num).forEach(i->sb.append("."));
        return sb.toString();
    }
    
    private boolean isValidChar(char c){
        if(c>='a'&&c<='z') return true;
        if(c>=48&&c<=57) return true;
        if(c=='-') return true;
        if(c=='_') return true;
        if(c=='.') return true;
        return false;
    }
}