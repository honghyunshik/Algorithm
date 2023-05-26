import java.util.*;

class Solution
{
 
    //1 2 4
    //5 4 4
    //5 + 8 + 16
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<A.length;i++){
            pq.add(A[i]);
            pq1.add(B[i]);
        }
        
        while(!pq.isEmpty()){
            answer += pq.poll()*pq1.poll();
       }
        return answer;
    }
    
}