class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        String answer = "";
        int play = toInt(play_time);
        int adv = toInt(adv_time);
        int[] tempSum = new int[play+1];
        for(String log:logs){
            
            String[] temp = log.split("-");
            int start = toInt(temp[0]);
            int end = toInt(temp[1]);
            tempSum[start]++;
            tempSum[end]--;
        }
        
        for(int i=1;i<tempSum.length;i++){
            
            tempSum[i] += tempSum[i-1];
        }
        
        long total = 0;
        int maxTime = 0;
        for(int i=0;i<adv;i++){
            total += tempSum[i];
        }
        long maxTotal = total;
        for(int i=0;i<play-adv;i++){
            
            total += tempSum[i+adv]-tempSum[i];
            if(total>maxTotal){
                maxTotal = total;
                maxTime = i+1;
            }
        }
        
        
        
        return toStr(maxTime);
    }
    
    String toStr(int num){
        
        int hour = num/3600;
        num%=3600;
        int minute = num/60;
        num%=60;
        int second = num;
        StringBuilder str = new StringBuilder();
        if(hour<10) str.append("0");
        str.append(hour + ":");
        if(minute<10) str.append("0");
        str.append(minute + ":");
        if(second<10) str.append("0");
        str.append(second);
        return str.toString();
    }
    
    int toInt(String str){
        
        String[] temp = str.split(":");
        return Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]); 
    }
}