class Solution {
    
    int[][] BOARD;
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    int N,M;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        int answer = -1;
        BOARD = board;
        N = board.length;
        M = board[0].length;
        
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1],0).cnt;
    }
    
    private Result dfs(int x1, int y1, int x2, int y2, int depth){
        
        boolean win = false;
        int max = depth;
        int min = 5*5;
        
        if(BOARD[x1][y1]==1){
            
            for(int i=0;i<4;i++){
                
                int nextX1 = x1 + D[i][0];
                int nextY1 = y1 + D[i][1];
                if(nextX1<0||nextX1>N-1||nextY1<0||nextY1>M-1) continue;
                if(BOARD[nextX1][nextY1]==0) continue;
                BOARD[x1][y1] = 0;
                Result result = dfs(x2,y2,nextX1,nextY1,depth+1);
                win |= !result.win;
                //x2, y2가 이긴거니까 x1, y1은 패배
                if(result.win){
                    max = Math.max(max,result.cnt);
                }else{
                    min = Math.min(min,result.cnt);
                }
                BOARD[x1][y1] = 1;
                
            }
            
        }
        return new Result(win,win?min:max); 
        
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