import java.util.*;

class Solution {
    
  
    int len = 0;
    PriorityQueue<Integer> asc = new PriorityQueue<>((a,b)->a-b);
    PriorityQueue<Integer> desc = new PriorityQueue<>((a,b)->b-a);
       
    public int[] solution(String[] operations) {
        
        
        int size = operations.length;
        for(int i=0;i<size;i++){
            String oper = operations[i];
            String command = oper.split(" ")[0];
            int num = Integer.parseInt(oper.split(" ")[1]);
            if(command.equals("I")) insert(num);
            else delete(num);
        }
        if(len==0) return new int[]{0,0};
        return new int[]{desc.poll(),asc.poll()};
 
    }
    
    void insert(int num){
        asc.add(num);
        desc.add(num);
        len++;
    }
    void delete(int num){
        
        if(len==0) {
            
            return;
        }//최댓값 삭제
        if(num==1){
            desc.poll();
        }else asc.poll();
        len--;
        if(len==0){
            asc.clear();
            desc.clear();
        }
    }
}