import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = numbers[i] + "";
        }
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        if(arr[0].equals("0")) return "0";
        return sb.toString();
    }
}