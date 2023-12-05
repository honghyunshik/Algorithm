import java.util.*;

class Solution {
    
    HashMap<String,ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String in:info){
            
            bruteForce(in.split(" "), "", 0);
        }
        
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for(int i=0;i<query.length;i++){
            
            query[i] = query[i].replaceAll(" and ","");
            String[] q = query[i].split(" ");
            ArrayList<Integer> now = map.get(q[0]);
            if(now==null) continue;
            answer[i] = getOver(now,Integer.parseInt(q[1]));
        }
        
        return answer;
    }
    
    private int getOver(ArrayList<Integer> list, int score){
        
        int l = 0, r = list.size();
        while(l<r){
            
            int mid = (l+r)/2;
            
            if(list.get(mid)<score){
                l = mid+1;
            }else r = mid;
        }
        return list.size()-l;
    }
    
    private void bruteForce(String[] info, String key, int idx){
        
        if(idx==info.length-1){
            
            int score = Integer.parseInt(info[idx]);
            
            ArrayList<Integer> list = map.getOrDefault(key,new ArrayList<>());
            list.add(score);
            map.put(key,list);
            return;
        }
        
        bruteForce(info,key+info[idx],idx+1);
        bruteForce(info,key+"-",idx+1);
    }
}