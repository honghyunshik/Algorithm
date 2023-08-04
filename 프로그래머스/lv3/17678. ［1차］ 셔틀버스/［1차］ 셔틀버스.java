import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] time = new int[timetable.length];
        for(int i=0;i<time.length;i++){
            time[i] = makeTime(timetable[i]);
        }
        Arrays.sort(time);
        int[] last = new int[n+1];
        Arrays.fill(last,m);
        
        int idx = 1;
        int lastTime = -1;
        for(int i=0;i<time.length;i++){
            
            int nowBus = 540 + t*(idx-1);
            while(nowBus<time[i]){
                nowBus += t;
                idx++;
            }
            if(idx<=n){
                last[idx]--;
                if(last[idx]==0){
                    if(idx==n) {
                        lastTime = time[i]-1;
                        break;
                    }
                    else idx++;
                }
            }
        }
        if(lastTime==-1) lastTime = 540+t*(n-1);
        
        return makeStr(lastTime);
    }
    
    private String makeStr(int num){
        
        int hour = num/60;
        String hourStr = hour<10?"0"+hour:hour+"";
        num %=60;
        String minuteStr = num<10?"0"+num:num+"";
        return hourStr+":"+minuteStr;
    }
    
    private int makeTime(String s){
        
        String[] list = s.split(":");
        int hour = Integer.parseInt(list[0]);
        int minute = Integer.parseInt(list[1]);
        return hour*60+minute;
    }
}