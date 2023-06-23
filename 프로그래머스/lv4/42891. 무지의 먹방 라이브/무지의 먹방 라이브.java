import java.util.*;

class Solution {
    
    public int solution(int[] food_times, long k) {
        
        int size = food_times.length;
        int[][] list = new int[size][2];
        long totalLen = 0;
        
        for(int i=0;i<size;i++){
            list[i][0] = food_times[i];
            list[i][1] = i;
            totalLen += food_times[i];
        }
        
        if(totalLen<=k) return -1;
        Arrays.sort(list,(a,b)->a[0]-b[0]);
        
        boolean[] visited = new boolean[size];
        long stack = 0;
        
        for(int i=0;i<size;i++){
    
            if(k<=(size-i)*(list[i][0]-stack)){
            
                long dif = k%(size-i);
                long cnt = 0;
                for(int j=0;j<size;j++){
                    if(visited[j]) continue;
                    if(cnt==dif) return j+1;
                    cnt++;
                }
                
            }else {
                k -= (size-i)*(list[i][0]-stack);
                visited[list[i][1]] = true; 
                stack = list[i][0];
            }
        }
        
        return 0;
    }
}