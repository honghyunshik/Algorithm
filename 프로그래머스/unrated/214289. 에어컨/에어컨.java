import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        
        // -10 도부터 40도까지 표현 -> 10 + 40 + 1 = 51
        int[][] dp = new int[onboard.length+1][51];
        int MAX = 9999999;
        int answer = MAX;
        for(int i=0;i<=onboard.length;i++){
            Arrays.fill(dp[i],MAX);
        }
        
        dp[0][convert(temperature)] = 0;
        
        
        for(int minute=1;minute<=onboard.length;minute++){
            
            int start = 0; int end = 0;
            //이전에 승객이 탑승하지 않은 경우
            if(onboard[minute-1]==0){
                start = -10; end = 40;
            }
            //이전에 승객이 탑승한 경우 t1~t2 값만 유효하다
            else{
                start = t1; end = t2;
            }
            
           
            
            for(int temp=start;temp<=end;temp++){
                    
                //현재온도 temp를 만드는 방법은 전에 온도 +1 or 유지 or 전에 온도 -1
                //전에 온도 +1의 경우 
                if(temp-1>=-10){
                    
                   //만약 전에 온도가 실외온도보다 낮을 경우 off여도 된다
                    if(temp-1<temperature) dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp-1)]);
                    //온도를 변경해야 하므로 a만큼 전력을 소모
                    else dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp-1)]+a);
                    
                }
                //전에 온도 유지의 경우
                //실내온도와 실외온도가 같다면 off여도 된다
                if(temp==temperature) dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp)]);
                //실내온도와 실외온도가 같지 않다면 온도 유지를 위해 b만큼 전력을 소모
                else dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp)]+b);
                
                //전에 온도 -1의 경우
                if(temp+1<=40){
                    //만약 전에 온도가 실외온도보다 높을 경우 off여도 된다
                    if(temp+1>temperature) dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp+1)]);
                    //온도를 변경해야 하므로 a만큼 전력을 소모
                    else dp[minute][convert(temp)] = Math.min(dp[minute][convert(temp)],dp[minute-1][convert(temp+1)]+a);
                }
                
                if(minute==onboard.length) answer = Math.min(answer,dp[minute][convert(temp)]);
            }
            
          
            
        }
        return answer;
    }
    
    int convert(int a){
        
        //-10 -> 41
        //-1 -> 50
        if(a<0) return a+51;
        return a;
    }
}