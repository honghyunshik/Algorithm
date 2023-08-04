import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int r = 0;
        for(int i=0;i<A.length;i++){
            while(r<B.length&&A[i]>=B[r]){
                r++;
            }
            if(r<B.length){
                answer++;
                r++;
            }
            if(r>=B.length) return answer;
        }
        return answer;
    }
}