class Solution {
    
    int[][] BOARD;
    int N,M;
    
    public int solution(int[][] board, int[][] skill) {
        
        int answer = 0;
        N = board.length;
        M = board[0].length;
        BOARD = new int[N+1][M+1];
        
        for(int[] sk:skill){
            int startL = sk[1];
            int startR = sk[2];
            int endL = sk[3];
            int endR = sk[4];
            int num = sk[0]==1?-sk[5]:sk[5];
            BOARD[startL][startR] += num;
            BOARD[startL][endR+1] -= num;
            BOARD[endL+1][startR] -= num;
            BOARD[endL+1][endR+1] += num;
        }
        //상하 합
        for(int i=1;i<=N;i++){
            
            for(int j=0;j<=M;j++){
                
                BOARD[i][j] += BOARD[i-1][j];
            }
        }
        
        //좌우 합
        for(int i=1;i<=M;i++){
            
            for(int j=0;j<=N;j++){
                
                BOARD[j][i] += BOARD[j][i-1];
            }
        }
        
        for(int i=0;i<N;i++){
            
            for(int j=0;j<M;j++){
                
                if(BOARD[i][j] + board[i][j]>0) answer++;
            }
        }
        return answer;
    }
}