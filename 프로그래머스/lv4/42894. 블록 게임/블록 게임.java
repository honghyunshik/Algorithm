class Solution {
    
    int N;
    int[][] BOARD;
    
    public int solution(int[][] board) {
        
        N = board.length;
        BOARD = board;
        int answer = 0;

        for(int i=0;i<N;i++){
            
            for(int j=0;j<N;j++){

                if(board[i][j]==0) continue;
                int type = getType(i,j,board[i][j]);
                int go = -1;
                if(type==1&&canDrop(i,j+1)&&canDrop(i,j+2)){
                    go=type;
                }else if(type==2&&canDrop(i+1,j-1)){
                    go=type;
                }else if(type==3&&canDrop(i+1,j+1)){
                    go=type;
                }else if(type==4&&canDrop(i,j-2)&&canDrop(i,j-1)){
                    go=type;
                }else if(type==5&&canDrop(i,j-1)&&canDrop(i,j+1)){
                    go=type;
                }
                if(go!=-1){
                    answer++;
                    remove(i,j,go);
                    j=0;
                    i=Math.max(0,i-1);
                }
            }
        }   
        return answer;
    }
    
    boolean canDrop(int n, int m){
        
        for(int i=0;i<=n;i++){
            if(BOARD[i][m]!=0) return false;
        }
        return true;
    }
    
    public void remove(int i, int j, int type){
        
        BOARD[i][j] = 0;
        BOARD[i+1][j] = 0;
        
        if(type==1){
            BOARD[i+1][j+1] = 0;
            BOARD[i+1][j+2] = 0;
        }else if(type==2){
            BOARD[i+2][j] = 0;
            BOARD[i+2][j-1] = 0;
        }else if(type==3){
            BOARD[i+2][j] = 0;
            BOARD[i+2][j+1] = 0;
        }else if(type==4){
            BOARD[i+1][j-1] = 0;
            BOARD[i+1][j-2] = 0;
        }else if(type==5){
            BOARD[i+1][j-1] = 0;
            BOARD[i+1][j+1] = 0;
        }
        
    }
                                                                                 
    
    
    //1-3, 1-4, 2-2, 2-3, 3-1 총 5가지 경우 삭제가능
    int getType(int n, int m, int val){
        
        if(isValid(n+1,m+2)&&BOARD[n][m+1]!=val&&BOARD[n][m+2]!=val&&BOARD[n+1][m]==val&&BOARD[n+1][m+1]==val&&BOARD[n+1][m+2]==val)
            return 1;
        if(isValid(n+2,m-1)&&BOARD[n][m-1]!=val&&BOARD[n+1][m-1]!=val&&BOARD[n+2][m-1]==val&&BOARD[n+1][m]==val&&BOARD[n+2][m]==val)
            return 2;
        if(isValid(n+2,m+1)&&BOARD[n][m+1]!=val&&BOARD[n+1][m+1]!=val&&BOARD[n+1][m]==val&&BOARD[n+2][m]==val&&BOARD[n+2][m+1]==val)
            return 3;
        if(isValid(n+1,m-2)&&BOARD[n][m-2]!=val&&BOARD[n][m-1]!=val&&BOARD[n+1][m-2]==val&&BOARD[n+1][m-1]==val&&BOARD[n+1][m]==val)
            return 4;
        if(isValid(n+1,m-1)&&isValid(n+1,m+1)&&BOARD[n][m-1]!=val&&BOARD[n][m+1]!=val&&BOARD[n+1][m-1]==val&&BOARD[n+1][m]==val&&BOARD[n+1][m+1]==val)
            return 5;
        
        return -1;
   
    } 
    
    boolean isValid(int n, int m){
        if(n<0||n>N-1||m<0||m>N-1) return false;
        return true;
    }
}