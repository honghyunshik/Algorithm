import java.util.*;
class Solution {
    
    //begin과 end 사이에 있는 최대의 약수를 찾기
    public int[] solution(long begin, long end) {
        
       int size = (int)(end-begin);
        
        int[] answer = new int[size+1];
        int idx = 0;
        for(long i=begin;i<=end;i++){
            
            answer[idx++] = (int)find(i);
            
        }
        return answer;
    }
    
    private long find(long num){
        
        if(num==1) return 0;
        ArrayList<Long> temp = new ArrayList<>();
        for(long div=2;div*div<=num;div++){
            
            if(num%div==0) {
                if(num/div>10000000) temp.add(div);
                else return num/div;
            }
        }
        if(!temp.isEmpty()) return temp.get(temp.size()-1);
        
        return 1;
    }
}