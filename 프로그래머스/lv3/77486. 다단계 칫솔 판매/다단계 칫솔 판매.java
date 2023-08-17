import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        HashMap<String,Integer> map = new HashMap<>();      //멤버들 index 저장
        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],i);
        }
        
        //0 : prev   1 : val
        int[][] link = new int[enroll.length][2];
        
        for(int i=0;i<referral.length;i++){
        
            String ref = referral[i];
            if(ref.equals("-")){
                link[i][0] = -1;
            }else{
                int refIdx = map.get(ref);
                link[i][0] = refIdx;
            }
        }
        for(int i=0;i<seller.length;i++){
            
            //System.out.println(Arrays.toString(link[1]));
            int val = amount[i]*100;
            int idx = map.get(seller[i]);
            //나눌 수 없거나 부모가 없을 경우
            if(link[idx][0]==-1||val<10) link[idx][1] += val>=10?val*9/10:val;
            else{
                while(val>0&&idx!=-1){
                    //System.out.println("seller : " + seller[i] + " idx : " + idx + " val : " + val);
                    int nowVal = val<10?val:val*9/10;
                    if(val%10!=0&&val>=10) nowVal = (int)Math.round((double)val*0.9+0.5);
                    link[idx][1]+=nowVal;
                    idx = link[idx][0];
                    val-=nowVal;
                }
            }
        }
        int[] answer = new int[link.length];
        for(int i=0;i<link.length;i++){
            answer[i] = link[i][1];
            //System.out.println(Arrays.toString(link[i]));
        }
        
        
        return answer;
    }
}