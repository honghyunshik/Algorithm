class Solution
{
    public int solution(int [][]board)
    {
        
        int n = board.length;
        int m = board[0].length;
        boolean isZero = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1){
                    isZero = false;
                    break;
                }
            }
        }
        if(isZero) return 0;
        int answer = 1;
        
        for(int i=1;i<n;i++){
            
            for(int j=1;j<m;j++){
                
                if(board[i][j]!=0){
                    
                    board[i][j] = Math.min(Math.min(board[i][j-1],board[i-1][j]),
                                          board[i-1][j-1])+1;
                    answer = Math.max(answer,board[i][j]*board[i][j]);
                }
            }
        }
        return answer;
    }
  
}