import java.util.*;

class Solution {
    
    //최대 점수 차이
    int maxDif = 0;
    //최대 점수 차이 배열
    //점수차이가 같을 경우 가장 낮은 점수를 더 많이 맞힌 경우
    int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        
        //라이언은 어피치가 맞춘 발 + 1만큼 맞춰야 k점 획득
        shoot(0,info,new int[11],0,0,n);
        return answer;
    }
    
    void shoot(int idx, int[] appeach, int[] ryan,int appeachScore,int ryanScore, int cnt){
        
        if(idx==10){
            
            int nowDif = ryanScore - appeachScore;
            ryan[10] = cnt;
            if(nowDif<=0) return;
            //점수 차이가 최대일 경우
            if(maxDif<nowDif){
                maxDif = nowDif;
                answer = Arrays.copyOf(ryan,ryan.length);
            }
            //점수 차이가 같을 경우 낮은 점수를 더 많이 맞힌 경우
            else if(maxDif==nowDif){
                
                for(int i=10;i>=0;i--){
                    
                    if(ryan[i]>answer[i]){
                        answer = Arrays.copyOf(ryan,ryan.length);
                    }else if(ryan[i]!=answer[i]) break;
                }
            }
            
            return;
        }
        
        //현재 idx 안이김
        //appeach가 0보다 크면 appeach가 점수 획득
        if(appeach[idx]>0) shoot(idx+1,appeach,ryan,appeachScore+10-idx,ryanScore,cnt);
        else shoot(idx+1,appeach,ryan,appeachScore,ryanScore,cnt);
        
        //현재 idx 이길 수 있으면
        if(appeach[idx]<cnt){
            ryan[idx] = appeach[idx]+1;
            shoot(idx+1,appeach,ryan,appeachScore,ryanScore+10-idx,cnt-appeach[idx]-1);
            ryan[idx] = 0;
        }
    }
}