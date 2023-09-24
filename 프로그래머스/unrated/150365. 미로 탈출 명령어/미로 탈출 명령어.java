class Solution {
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        
        //x,y -> r,c 까지의 거리
        int dis = Math.abs(r-x) + Math.abs(c-y);
        
        //이동해야 하는 거리가 dis보다 작거나 차이가 홀수인 경우 불가능
        if(dis>k||(k-dis)%2==1) return "impossible";

        //사전순으로 d l r u
        
        StringBuilder sb = new StringBuilder();
        //왔다갔다 불가능
        if(dis==k){
            down(x,y,r,c,sb);
            left(x,y,r,c,sb);
            right(x,y,r,c,sb);
            up(x,y,r,c,sb);
        }else{
         
            int dif = (k-dis)/2;
            
            //목표보다 최대 얼마만큼 내려갈 수 있을까?
            int down = Math.min(dif,n-Math.max(x,r));
            //목표보다 최대 얼마만큼 왼쪽으로 갈 수 있을까?
            int left = Math.min(Math.min(y,c)-1,dif-down);
            
            down(x,y,Math.max(x,r)+down,y,sb);
            dif-=down;
            left(x,y,r,c,sb);
            //아직 더 움직어야돼? 이번에는 왼쪽으로 가자
            if(dif>0){
                //왼쪽으로 쭉 가면 끝나?
                if(left==dif){
                    left(x,y,x,y-left,sb);
                    right(x,y-left,x,y,sb);
                }//아니면 왕복 운동 해주자
                else{
                    left(x,y,x,y-left,sb);
                    for(int i=0;i<dif-left;i++){
                        sb.append("rl");
                    }
                    right(x,y-left,x,y,sb);
                }
            }
            right(x,y,r,c,sb);
            up(Math.max(r,x)+down,y,r,c,sb);
            
        }
        return sb.toString();
    }
    
    //왼쪽으로 이동
    void left(int x, int y, int r, int c, StringBuilder sb){
        
         //목표(c)가 더 작아야 왼쪽으로 이동 
        for(int i=y;i>c;i--){
            sb.append("l");
        }
    }
    
    //오른쪽으로 이동
    void right(int x, int y, int r, int c, StringBuilder sb){
        
        //목표(c)가 더 커야 오른쪽으로 이동
        for(int i=y;i<c;i++){
            sb.append("r");
        }
    }
    
    //위로 이동
    void up(int x, int y, int r, int c, StringBuilder sb){
        
        //목표(r)이 더 작아야 위로 이동
        for(int i=x;i>r;i--){
            sb.append("u");
        }
    }
    
    void down(int x, int y, int r, int c, StringBuilder sb){
        
        //목표(r)이 더 커야 아래로 이동
        for(int i=x;i<r;i++){
            sb.append("d");
        }
    }
}