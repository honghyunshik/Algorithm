import java.util.*;

class Solution {


    public long solution(int n, int m, int x, int y, int[][] queries) {

       
        int len = queries.length;
        long x2 = x, x1 = x;
        long y2 = y, y1 = y;

        for(int i=len-1;i>=0;i--){

            int[] query = queries[i];
            int dir = query[0];
            int dis = query[1];

            if(dir==0){
                //->
                if(y1>0){
                    y1 += dis;
                    if(y1>m-1) return 0;
                }
                y2 = Math.min(m-1,y2+dis);
            }else if(dir==1){
                
                //<-
                if(y2<m-1){
                    y2 -= dis;
                    if(y2<0) return 0;
                }
                y1 = Math.max(0,y1-dis);
                
            }else if(dir==2){

                //벽에 닿아 있으면
                if(x1>0){
                    x1 += dis;
                    if(x1>n-1) return 0;     
                }
                x2 = Math.min(n-1,x2+dis);
                
            }else if(dir==3){

                //벽에 닿아 있으면
                if(x2<n-1){
                    x2 -= dis;
                    if(x2<0) return 0;
                }
                x1 = Math.max(0,x1-dis);
            }
        }

        return (x2-x1+1)*(y2-y1+1);
    }
}


