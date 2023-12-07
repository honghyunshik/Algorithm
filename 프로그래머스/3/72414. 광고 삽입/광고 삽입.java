import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = parseInt(play_time);
        int advTime = parseInt(adv_time);
        int[] total = new int[playTime+1];
        
        for(String log:logs){
            
            String[] temp = log.split("-");
            int startTime = parseInt(temp[0]);
            int endTime = parseInt(temp[1]);
            
            total[startTime]++;
            if(endTime<playTime+1) total[endTime]--;
        }
        
        for(int time=1;time<=playTime;time++){
            total[time] += total[time-1];
        }

        long nowMax = 0;     //최대 부분합
        long tempSum = 0;        //현재 부분합
        int nowTime = 0;        //최대 부분합의 시간
        for(int time=0;time<=advTime;time++){
            tempSum += total[time];
        }
        nowMax = tempSum;
        for(int time=1;time<=playTime-advTime;time++){
            tempSum -= total[time];
            tempSum += total[advTime+time];
            if(tempSum>nowMax){
                nowMax = tempSum;
                nowTime = time+1;
            }
        }
        
        return parseStr(nowTime);
    }
    
    private String parseStr(int time){
        
        String second = time%60+"";
        if(time%60<10) second = "0" + second;
        
        String minute = time/60%60+"";
        if(time/60%60<10) minute = "0" + minute;
        
        String hour = time/3600 + "";
        if(time/3600<10) hour = "0" + hour;
        
        return hour + ":" + minute + ":" + second;
    }
    
    private int parseInt(String time){
        
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
    }
}