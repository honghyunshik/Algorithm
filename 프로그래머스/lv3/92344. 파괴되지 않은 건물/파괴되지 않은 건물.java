import java.util.*;

class Solution {
    
    int[][] BOARD;
    int N,M;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        BOARD = new int[N+1][M+1];
        for(int[] sk:skill){
            
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];
            if(sk[0]==1) degree = -degree;
            BOARD[r1][c1] += degree;
            BOARD[r1][c2+1] -= degree;
            BOARD[r2+1][c1] -= degree;
            BOARD[r2+1][c2+1] += degree;
            
        }
        
        //좌우 합
        for(int i=0;i<N;i++){
            
            for(int j=1;j<M;j++){
                
                BOARD[i][j] += BOARD[i][j-1];
            }
        }    
        
        //상하 합
        for(int i=0;i<M;i++){
            
            for(int j=1;j<N;j++){
                
                BOARD[j][i] += BOARD[j-1][i];
            }
        }
        
        
        for(int i=0;i<N;i++){
            
            for(int j=0;j<M;j++){
                
                if(BOARD[i][j] + board[i][j] >0) answer ++;
            }
        }
        return answer;
    }
}