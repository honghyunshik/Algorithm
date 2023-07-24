import java.util.*;

class Solution {
    
    public int solution(int k, int n, int[][] reqs) {

        Arrays.sort(reqs,(a,b)->{
            if(a[2]==b[2]&&a[0]==b[0]) return a[1]-b[1];
            if(a[2]==b[2]) return a[0]-b[0];
            return a[2]-b[2];
        });
        //1~n-k+1
        int[][] dif = new int[k+1][n-k+2];
        
        for(int i=1;i<=k;i++){
            
            for(int men=1;men<=n-k+1;men++){
                
                int wait = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                
                for(int c=1;c<=men;c++){
                    pq.add(0);
                }
                
                for(int j=0;j<reqs.length;j++){
                    
                    if(i>reqs[j][2]) continue;
                    if(i<reqs[j][2]) break;
                    int now = pq.poll();
                    if(now<=reqs[j][0]){
                        pq.add(reqs[j][0] + reqs[j][1]);
                    }else{
                        pq.add(now + reqs[j][1]);
                        wait += now - reqs[j][0];
                    }
                
                }
                dif[i][men] = wait;
            }
        }
        
        int[] pointer = new int[k+1];
        Arrays.fill(pointer,1);
        
        
        
        for(int i=k;i<n;i++){
            
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for(int j=1;j<=k;j++){
                int point = pointer[j];
                if(point==n-k+1) continue;
                if(max<dif[j][point]-dif[j][point+1]){
                    max = dif[j][point] - dif[j][point+1];
                    maxIdx = j;
                }
            }
            pointer[maxIdx]++;
        }
        int answer = 0;
         for(int i=1;i<=k;i++){
            int point = pointer[i];
            answer += dif[i][point];
        }
        
        return answer;
    }
    
   
    
    
}