import java.util.*;

class Solution {
    
    public int solution(String[] lines) {
        int answer = 1;
        
        int[][] arr = new int[lines.length][2];
        for(int i=0;i<lines.length;i++){
            String[] temp = lines[i].split(" ");
            arr[i] = convert(temp[1],temp[2]);
        }
        
        
        for(int i=0;i<arr.length;i++){
            int temp = 1;
            int last = arr[i][1]+1000;
            for(int j=i+1;j<arr.length;j++){
                if(last>arr[j][0]){
                    temp++;   
                }
            }
            answer = Math.max(temp,answer);
        }
        
        return answer;
    }
    
    private int[] convert(String start, String len){
        
        String[] start_arr = start.split(":");
        int start_time = Integer.parseInt(start_arr[0])*60*60*1000
            + Integer.parseInt(start_arr[1])*60*1000
            + (int)(Double.parseDouble(start_arr[2])*1000);
        int len_time = (int)(Double.parseDouble(len.replace("s",""))*1000);
        
        return new int[]{start_time-len_time+1,start_time};
    }
    
}