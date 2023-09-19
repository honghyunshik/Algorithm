import java.util.*;

class Solution {
    
    List<Character> list = new ArrayList<>();
    HashMap<Character, int[][]> locMap = new HashMap<>();
    char[][] BOARD;;
    
    
    public String solution(int m, int n, String[] board) {
        
        PriorityQueue<Character> pq = new PriorityQueue<>();
        BOARD = new char[m][n];
        
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[i].length();j++){
                
                BOARD[i][j] = board[i].charAt(j);
                if(board[i].charAt(j)!='.'&&board[i].charAt(j)!='*'){
                    
                    pq.add(board[i].charAt(j));
                    int[][] arr = locMap.get(board[i].charAt(j));
                    if(arr==null){
                        arr = new int[2][2];
                        arr[0][0] = i;
                        arr[0][1] = j;
                    }else{
                        arr[1][0] = i;
                        arr[1][1] = j;
                    }
                    locMap.put(board[i].charAt(j),arr);
                    
                }
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
            pq.poll();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(list.size()>0){
            
            for(int i=0;i<list.size();i++){
                
                char nowChar = list.get(i);
                
                int leftX = locMap.get(nowChar)[0][0];
                int leftY = locMap.get(nowChar)[0][1];
                int rightX = locMap.get(nowChar)[1][0];
                int rightY = locMap.get(nowChar)[1][1];
                
                if(canDelete(nowChar,leftX,leftY,rightX,rightY)){
                    list.remove(i);
                    sb.append(nowChar);
                    delete(leftX,leftY,rightX,rightY);
                    break;
                }
                
                if(i==list.size()-1) return "IMPOSSIBLE";
            }
        }
        
        
        return sb.toString();
    }
    
    void delete(int leftX, int leftY, int rightX, int rightY){
        
        BOARD[leftX][leftY] = '.';
        BOARD[rightX][rightY] = '.';
    }
    
    boolean linearRow(int x1, int y1, int y2, char nowChar){
        
        for(int row=y1;row<=y2;row++){
            if(BOARD[x1][row]!='.'&&BOARD[x1][row]!=nowChar) return false;
        }
        return true;
    }
    
    boolean linearColumn(int x1, int x2, int y1, char nowChar){
        
        for(int col=x1;col<=x2;col++){
            if(BOARD[col][y1]!='.'&&BOARD[col][y1]!=nowChar) return false;
        }
        return true;
    }
    
    
    boolean canDelete(char nowChar, int leftX, int leftY, int rightX, int rightY){
        
        //가는 방법은 두가지
        //1. leftX -> rightX 후에 leftY -> rightY
        //2. leftY -> rightY 후에 leftX -> rightX
        boolean first = true, second = true;
        int minX = Math.min(leftX,rightX);
        int minY = Math.min(leftY,rightY);
        int maxX = Math.max(leftX,rightX);
        int maxY = Math.max(leftY,rightY);
        
        ///첫 번째 방법
        if(linearColumn(minX,maxX,leftY,nowChar)&&linearRow(rightX,minY,maxY,nowChar)) return true;
        
        //두번째 방법
        if(linearRow(leftX,minY,maxY,nowChar)&&linearColumn(minX,maxX,rightY,nowChar)) return true;
       
         return false;
        
    }
}