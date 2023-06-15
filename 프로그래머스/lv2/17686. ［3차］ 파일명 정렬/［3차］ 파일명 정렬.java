import java.util.*;
class Solution {
    
    
    public String[] solution(String[] files) {
        
        String[] answer = new String[files.length];
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->{
            
            //이름이 같을 경우 숫자 순으로 정렬
            if(a[1].compareTo(b[1])==0){
                
                int aNum = Integer.parseInt(a[2]);
                int bNum = Integer.parseInt(b[2]);
                if(aNum==bNum){
                    return Integer.parseInt(a[3])-Integer.parseInt(b[3]);
                }
                return aNum-bNum;
            }
            
            return a[1].compareTo(b[1]);
        });
        for(int i=0;i<files.length;i++){
            
            String file = files[i];
            String head = "";
            String number = "";
         
            int startIdx = -1;
            for(int j=0;j<file.length();j++){
                if(file.charAt(j)>='0'&&file.charAt(j)<='9'){
                    head = file.substring(0,j);
                    startIdx = j;
                    break;
                }
            }
            int lastIdx = Math.min(startIdx+5,file.length());
            for(int k=startIdx;k<lastIdx;k++){

                if(file.charAt(k)<'0'||file.charAt(k)>'9'){
                    break;
                }
                
                number += file.charAt(k);
            }
           
            String[] splitFile = new String[]{file,head.toLowerCase()
                                              ,number,i+""};
         
            pq.add(splitFile);
        }
        
        for(int i=0;i<files.length;i++){
            
            answer[i] = pq.poll()[0];
        }
        return answer;
    }
}