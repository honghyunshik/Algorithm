import java.util.*;
class Solution {
    public int solution(String[] lines) {
        
        int answer = 0;
        int[][] arr = new int[lines.length][2];
        
        for(int i=0;i<lines.length;i++){
            
            String[] li = lines[i].split(" ");
            arr[i] = makeTime(li[1],li[2]);
        }
        
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int cnt = 0;
            for(int j=i;j<arr.length;j++){   
                if(arr[i][1]+1000>arr[j][0]&&arr[j][1]>=arr[i][1]){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
        }
        
        return max;
    }
    
    private int[] makeTime(String time, String len){
            
        int[] ans = new int[2];
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        int second = Integer.parseInt(time.substring(6,8));
        int se = Integer.parseInt(time.substring(9,time.length()));
        ans[1] = hour*3600000 + minute * 60000 + second * 1000 + se;

        len = len.replace("s","");
        if(len.contains(".")){
            String[] li = len.split("\\.");
            int second2 = Integer.parseInt(li[0]);
            int se2 = Integer.parseInt(li[1]);
            if(li[1].length()<=1) se2*=100;
            else if(li[1].length()<=2) se2*=10;
            ans[0] = Integer.max(0,ans[1] - (second2*1000+se2) + 1);
        }else{
            ans[0] = Integer.max(0,ans[1]-Integer.parseInt(len)*1000 + 1);
        }
        return ans;

    }
    

}
