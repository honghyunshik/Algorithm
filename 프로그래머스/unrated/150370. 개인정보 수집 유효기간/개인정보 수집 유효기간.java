import java.util.*;

class Solution {
    
    HashMap<String,Integer> typeMap = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        for(String term:terms){
            String type = term.split(" ")[0];
            int len = Integer.parseInt(term.split(" ")[1]);
            typeMap.put(type,len);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int idx=0;idx<privacies.length;idx++){
            
            String priveDate = privacies[idx].split(" ")[0];
            String type = privacies[idx].split(" ")[1];
            
            String endDate = makeEndDate(priveDate,typeMap.get(type));
            if(today.compareTo(endDate)>0) list.add(idx+1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int idx=0;idx<list.size();idx++){
            answer[idx] = list.get(idx);
        }
  
        return answer;
    }
    
    String makeEndDate(String priveDate, int len){
        
        String[] temp = priveDate.split("\\.");
        
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
       
        year += len/12;
        len%=12;
        month+=len;
        if(day==1){
            day = 28;
            month--;
        }else day--;
        
        if(month%12!=0){
            year += month/12;
            month%=12;
        }else{
            year += month/12-1;
            month = 12;
        }
        StringBuilder sb = new StringBuilder(year+".");
        if(month<10) sb.append("0");
        sb.append(month+".");
        if(day<10) sb.append("0");
        sb.append(day);
        
        return sb.toString();
          
 
    }
    
}