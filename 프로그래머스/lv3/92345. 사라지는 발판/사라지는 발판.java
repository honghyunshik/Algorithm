class Solution {
    
    int[][] BOARD;
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    int N, M;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        BOARD = board;
        N = board.length;
        M = board[0].length;
        
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1],0).cnt;
    }
    
    Result dfs(int aL,int aR, int bL, int bR, int dis){
        
        
        boolean win = false;
        int max = 0, min = Integer.MAX_VALUE;
        if(BOARD[aL][aR]==0) return new Result(false,0);
        
        for(int i=0;i<4;i++){
            
            int nextL = aL + D[i][0];
            int nextR = aR + D[i][1];
            if(!can(nextL,nextR)) continue;
            BOARD[aL][aR] = 0;
            Result result = dfs(bL,bR,nextL,nextR,dis+1);
            BOARD[aL][aR] = 1;
            if(!result.win){
                win = true;
                min = Math.min(min,result.cnt);
            }else max = Math.max(max,result.cnt);
        }
        
        if(max==0&&min==Integer.MAX_VALUE){
            return new Result(false,0);
        }
        return new Result(win,win?min+1:max+1);
    }
    
    boolean can(int x, int y){
        
        if(x<0||x>N-1||y<0||y>M-1) return false;
        if(BOARD[x][y]==0) return false;
        return true;
    }
}

class Result{
    
    boolean win;
    int cnt;
    Result(boolean win, int cnt){
        this.win = win;
        this.cnt = cnt;
    }
}