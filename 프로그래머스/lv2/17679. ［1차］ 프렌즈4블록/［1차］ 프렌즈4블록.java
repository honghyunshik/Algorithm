import java.util.*;

class Solution {
    
    int[][] D = {{0,0},{0,1},{1,0},{1,1}};
    char[][] BOARD;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        BOARD = new char[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[i].length();j++){
                
                BOARD[i][j] = board[i].charAt(j);
            }
        }
        
        ArrayList<int[]> delete = delete();
        while(!delete.isEmpty()){
            
            for(int[] arr:delete){
                
                int l = arr[0];
                int r = arr[1];
                System.out.println("l : " + l + " r : " + r);
                for(int i=0;i<4;i++){
                    if(BOARD[l+D[i][0]][r+D[i][1]]!='0'){
                        answer++;
                        BOARD[l+D[i][0]][r+D[i][1]] = '0';
                    }
                    
                }
            }
            goDown();
            
            delete = delete();
  
        }
        return answer;
    }
    
    private void goDown(){
        
        for(int j=0;j<BOARD[0].length;j++){
            
            for(int i=BOARD.length-1;i>0;i--){
                
                if(BOARD[i][j]=='0'){
                    
                    for(int k=i-1;k>=0;k--){
                        
                        if(BOARD[k][j]!='0'){
                            swap(i,j,k,j);
                            break;
                        }
                    }
                    
                }
            }
        }
    }
    
    private void swap(int firstL, int firstR, int secondL, int secondR){
        
        char temp = BOARD[firstL][firstR];
        BOARD[firstL][firstR] = BOARD[secondL][secondR];
        BOARD[secondL][secondR] = temp;
    }
    
    private ArrayList<int[]> delete(){
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<BOARD.length;i++){
        
            for(int j=0;j<BOARD[i].length;j++){
                
                if(BOARD[i][j]=='0') continue;
                if(i==BOARD.length-1||j==BOARD[i].length-1) continue;
                boolean flag = true;
                for(int d=1;d<4;d++){
                    
                    if(BOARD[i][j]!=BOARD[i+D[d][0]][j+D[d][1]]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        return list;
    }
    
}