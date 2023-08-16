import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int play = strToInt(play_time);     //총 상영시간
        int ad = strToInt(adv_time);        //총 광고시간
        //빨리 끝나는 순서대로 정렬
        long[] cntList = new long[play+1];
        for(int i=0;i<logs.length;i++){
            String[] log = logs[i].split("-");
            int start = strToInt(log[0]);
            int end = strToInt(log[1]);
            for(int j=start;j<end;j++){
                cntList[j]++;
            }
        }
        
        
        for(int i=0;i<play;i++){
            cntList[i+1]+=cntList[i];
        }
        
        long max = cntList[ad-1];
        long sum = 0;
        int start = 0;
        
        //i는 start고 i+ad가 end
        for(int i=0;i<=play-ad;i++){

            long temp = cntList[i+ad]-cntList[i]; 
            if(max<temp){
                max = temp;
                start = i+1;
            }
        }

        String answer = intToStr(start);
        
        return answer;
    }
    
    private String intToStr(int num){
        
        int hour = num/3600;
        num %= 3600;
        int minute = num/60;
        num %= 60;
        int second = num;
        String str = "";
        if(hour<10) str+="0";
        str+=hour + ":";
        if(minute<10) str+="0";
        str+=minute + ":";
        if(second<10) str+="0";
        str+=second;
        return str;
    }
    
    
    private int strToInt(String str){
        
        String[] p = str.split(":");
        int hour = Integer.parseInt(p[0]);
        int minute = Integer.parseInt(p[1]);
        int second = Integer.parseInt(p[2]);
        return hour*3600+minute*60+second;
    }
}