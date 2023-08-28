import java.util.*;

class Solution {
    public int solution(int[] a) {
        if(a.length==1) return 1;
        int answer = 2;
        int[] dpAsc = new int[a.length];
        int[] dpDesc = new int[a.length];
        dpAsc[0] = a[0];
        dpDesc[a.length-1] = a[a.length-1];
        for(int i=1;i<a.length;i++){
            dpAsc[i] = Math.min(a[i],dpAsc[i-1]);
            dpDesc[a.length-1-i] = Math.min(a[a.length-1-i],dpDesc[a.length-i]);
        }
        
        for(int i=1;i<a.length-1;i++){
            
            int leftMax = dpAsc[i-1];
            int rightMax = dpDesc[i+1];
            if(leftMax<a[i]&&rightMax<a[i]) continue;
            answer++;
        }
        
        return answer;
    }
}