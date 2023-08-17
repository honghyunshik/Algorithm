class Solution {
    public String[] solution(String[] s) {
        
         String[] answer = new String[s.length];
       
        for(int idx=0;idx<s.length;idx++){
            
            answer[idx] = makeStr(s[idx]);
        }
        
        
    
        return answer;
    }
    
    private String makeStr(String str){
        
        StringBuilder sb = new StringBuilder(str);
        
        int l = 0;
        int size = sb.length();
    
        StringBuilder plus = new StringBuilder();
    
        while(l<size-2){
            
            if(sb.substring(l,l+3).equals("110")){
                
                sb.delete(l,l+3);
                size -= 3;
                plus.append("110");
                l = Math.max(0,l-2);
            }else l++;
        }
       
       
        boolean flag = false;
        for(int i=sb.length()-1;i>=0;i--){
            
            if(sb.charAt(i)=='0'){
                sb.insert(i+1,plus);
                flag = true;
                break;
            }
           
        }
        if(!flag) sb.insert(0,plus);
        
        return sb.toString();
    }
    
}