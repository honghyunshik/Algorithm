class Solution {
    
    int[][] BOARD;
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    int N,M;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        BOARD = board;
        N = board.length;
        M = board[0].length;
        
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1]).dis;
    }
    
    Result dfs(int x1, int y1, int x2, int y2){
        
        //내 발판이 사라졌다면 패배
        if(BOARD[x1][y1]==0) return new Result(false,0);
        
        boolean win = false;
        int max = 0;
        int min = Integer.MAX_VALUE;
        BOARD[x1][y1] = 0;
        for(int i=0;i<4;i++){
            
            int nextX1 = x1 + D[i][0];
            int nextY1 = y1 + D[i][1];
            if(!valid(nextX1,nextY1)) continue;
            Result result = dfs(x2,y2,nextX1,nextY1);
            //이길 수 있다면 최대한 짧게
            if(!result.win) {
                win = true;
                min = Math.min(result.dis,min);    
            }
            else max = Math.max(result.dis,max);
            
        }
        BOARD[x1][y1] = 1;
        //상하좌우 다 이동 불가능 -> 패배
        if(max==0&&min==Integer.MAX_VALUE){
            return new Result(false,0);   
        }
   
        return new Result(win,win?min+1:max+1);
    }
    
    boolean valid(int x, int y){

        //보드 밖인 경우
        if(x<0||x>N-1||y<0||y>M-1) return false;
        //발판이 없으면 안됨
        if(BOARD[x][y]==0) return false;
        return true;
    }
}

class Result{
    boolean win;
    int dis;
    Result(boolean win, int dis){
        this.win = win;
        this.dis = dis;
    }
}