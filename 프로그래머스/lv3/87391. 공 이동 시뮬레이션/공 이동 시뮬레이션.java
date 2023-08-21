class Solution {
      
    public long solution(int n, int m, int x, int y, int[][] queries) {
        
        long answer = -1;
        long x1 = x, x2 = x, y1 = y, y2 = y;
        for(int i=queries.length-1;i>=0;i--){
            
            int dir = queries[i][0];
            int dx = queries[i][1];
            if(dir==0){
                if(y1!=0){
                    if(y1+dx>m-1) return 0;
                    y1 += dx;
                }y2 = Math.min(m-1,y2+dx);
            }else if(dir==1){
                if(y2!=m-1){
                    if(y2-dx<0) return 0;
                    y2 -= dx;
                }y1 = Math.max(0,y1-dx);
            }else if(dir==2){
                if(x1!=0){
                    if(x1+dx>n-1) return 0;
                    x1 += dx;
                }x2 = Math.min(n-1,x2+dx);
            }else{
                if(x2!=n-1){
                    if(x2-dx<0) return 0;
                    x2 -= dx;
                }x1 = Math.max(0,x1-dx);
            }
        }
        
        return (x2-x1+1)*(y2-y1+1);
    }
}