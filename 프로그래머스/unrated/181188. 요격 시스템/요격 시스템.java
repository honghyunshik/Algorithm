import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets,(a,b)->a[1]-b[1]);
        int lastEnd = targets[0][1];
        for(int i=1;i<targets.length;i++){
            int start = targets[i][0];
            int end = targets[i][1];
            if(lastEnd<=start){
                answer++;
                lastEnd = end;
            }
        }
        return answer;
    }
}