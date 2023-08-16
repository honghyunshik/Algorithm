import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int min = a[0];
        leftMin[0] = min;
        for(int i=1;i<a.length;i++){
            
            min = Math.min(a[i],min);
            leftMin[i] = min;
        }
        
        min = a[a.length-1];
        rightMin[a.length-1] = min;
        for(int i=a.length-2;i>=0;i--){
            
            min = Math.min(a[i],min);
            rightMin[i] = min;
        }
        
        for(int i=1;i<a.length-1;i++){
            
            if(leftMin[i-1]>a[i]||rightMin[i+1]>a[i]) answer++;
        }
        return answer;
    }
}