import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        int[] answer = {};
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((a,b)->a-b);
        int size = 0;
        for(String str:operations){
            
            if(str.startsWith("I")){
                int add = Integer.parseInt(str.substring(2,str.length()));
                pqMax.add(add);
                pqMin.add(add);
                size++;
            }else{
                if(size==0) continue;
                if(str.length()==3){
                    pqMax.poll();
                }else{
                    pqMin.poll();
                }
                size--;
            }
        }
        if(size==0)return new int[]{0,0};
        HashSet<Integer> set = new HashSet<>();
        while(!pqMax.isEmpty()){
            int idx = pqMax.poll();
            set.add(idx);
        }
         int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       
        while(!pqMin.isEmpty()){
            int idx = pqMin.poll();
            if(set.contains(idx)){
                min = Math.min(idx,min);
                max = Math.max(idx,max);
            }
        }
        return new int[]{max,min};
    }
}