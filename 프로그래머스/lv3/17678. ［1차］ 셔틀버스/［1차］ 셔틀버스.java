import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        String answer = "";
        int ans = -1;
        int[] bus = new int[timetable.length];
        for(int i=0;i<bus.length;i++){
            bus[i] = toInt(timetable[i]);
        }
        Arrays.sort(bus);
        
        int now = 540;
        int idx = 0;
        for(int i=0;i<n;i++){
            
            
            for(int j=0;j<m;j++){
                
                //마지막인 경우
                if(i==n-1&&j==m-1){
                    
                    //이미 다 탔다면
                    if(idx>=bus.length) ans = now;
                    else if(bus[idx]>now) ans = now;
                    else ans = bus[idx]-1;
                }
                if(idx<bus.length&&bus[idx]<=now){
                    idx++;
                }
            }
            now += t;
            
        }
        return toStr(ans);
    }
    
    String toStr(int num){
        
        int hour = num/60;
        int minute = num%60;
        String h = hour<10?"0":"";
        h += hour;
        String m = minute<10?"0":"";
        m += minute;
        return h+":"+m;
        
    }
    
    int toInt(String str){
        
        String[] temp = str.split(":");
        
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
}