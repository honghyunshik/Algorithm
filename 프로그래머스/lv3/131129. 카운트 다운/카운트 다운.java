import java.util.*;
class Solution {
    
    //
    public int[] solution(int target) {
        
        int MAX = 9999999;
        //0은 val   2는 싱글+볼
        int[][] list = new int[Math.max(61,target+1)][2];
        for(int i=1;i<list.length;i++){
            list[i][0] = MAX;
        }
        for(int i=1;i<=20;i++){
            list[i][0] = 1;
            list[i][1] = 1;
            list[i*2][0] = 1;
            list[i*2][1] = 0;
            list[i*3][0] = 1;
            list[i*3][1] = 0;
        }
        
        list[50][0] = 1;
        list[50][1] = 1;
        
        for(int num=21;num<=target;num++){
            
            int min = list[num][0];
            int cnt = list[num][1];
            
            for(int i=Math.max(1,num-60);i<num;i++){
               
                int j = num-i;
                int tempValSum = list[i][0] + list[j][0];
                int tempCntSum = list[i][1] + list[j][1];
                if(min>tempValSum||
                   min==tempValSum&&cnt<tempCntSum){  
                    min = tempValSum;
                    cnt = tempCntSum;
                }           
            }
            list[num][0] = min;
            list[num][1] = cnt;
            
            //list[num] = new int[]{min,cnt};
        }
        
        
        return list[target];
    }
}