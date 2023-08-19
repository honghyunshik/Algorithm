import java.util.*;

class Solution {
    
    HashMap<String,Integer> map = new HashMap<>();
    int[] answer;
    int[] pointer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],i);
        }
        pointer = new int[enroll.length];
        for(int i=0;i<referral.length;i++){
            if(referral[i].equals("-")) pointer[i] = -1;
            else pointer[i] = map.get(referral[i]);
        }
        for(int i=0;i<seller.length;i++){
            sell(map.get(seller[i]),amount[i]*100);
        }
       return answer;
    }
    
    void sell(int idx, int amount){
        
        if(idx==-1) return;
        
        //1원 미만인 경우 모두 가짐
        if(amount<10) {
            answer[idx] += amount;
            return;
        }
        
        int mod = amount/10;
        answer[idx] += amount - mod;
        sell(pointer[idx],mod);
        
        
    }
}