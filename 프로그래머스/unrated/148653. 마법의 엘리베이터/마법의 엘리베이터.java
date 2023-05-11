
import java.util.*;
class Solution {
    //1644 의 경우 일단 
    public int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(storey,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int val = node.val;
            int dis = node.dis;
            if(val==0){
                answer = Math.min(answer,dis);
                continue;
            }
            
            if(val%10==0){
                queue.add(new Node(val/10,dis));
            }else if(val<10){
                int last = val%10;
                int next = Math.min(last,10-last+1);
                queue.add(new Node(val/10,dis+next));
            }else{
                int last = val%10;
                queue.add(new Node((val-last)/10,dis+last));
                queue.add(new Node((val+10-last)/10,dis+10-last));
            }
        }
        return answer;
    }
}

class Node{
    int val, dis;
    Node(int val, int dis){
        this.val = val;
        this.dis = dis;
    }
}