import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<gems.length;i++){ 
            set.add(gems[i]);
        }
        int type = set.size();
        int start = 0;
        int[] answer = new int[]{0,Integer.MAX_VALUE};
        for(int i=0;i<gems.length;i++){
            
            String gem = gems[i];
            int cnt = map.getOrDefault(gem,0);
            map.put(gem,++cnt);

            
            if(cnt==1){
                if(--type==0){
                    for(int j=start;j<i;j++){
                        cnt = map.get(gems[j]);
                        map.put(gems[j],cnt-1);
                        
                        if(cnt==1) {
                            if(answer[1]-answer[0]>i-j){
                                answer[1] = i+1;
                                answer[0] = j+1;
                            }
                            type++;
                            start = j+1;
                            break;
                        }
                    }
                    
                }
            }
            
        }
        if(answer[0]==0&&answer[1]==Integer.MAX_VALUE) return new int[]{1,1};
        return answer;
    }
}