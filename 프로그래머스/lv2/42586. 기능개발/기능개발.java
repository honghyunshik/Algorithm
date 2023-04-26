import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            
            int day = (double)(100-progresses[i])/speeds[i]%1==0?(100-progresses[i]
                                )/speeds[i]:(100-progresses[i])/speeds[i]+1;
            queue.add(day);
        }
        int now = queue.peek();
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
         
            int day = queue.poll();
            
            if(day>now){
                now = day;
                list.add(cnt);
                cnt = 1;
            }else{
                cnt++;
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}