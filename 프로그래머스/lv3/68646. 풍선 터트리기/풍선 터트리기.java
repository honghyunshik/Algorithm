import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = a.length;
        
        int leftMin = Integer.MAX_VALUE;
        
        int[] minList = new int[a.length];
        
        int rightMin = Integer.MAX_VALUE;
        for(int i=a.length-1;i>=0;i--){
            rightMin = Math.min(a[i],rightMin);
            minList[i] = rightMin;
        }
        for(int i=1;i<a.length-1;i++){
            leftMin = Math.min(leftMin,a[i-1]);
            rightMin = minList[i+1];
            if(a[i]>leftMin&&a[i]>rightMin) answer--;
        }
        return answer;
    }
}