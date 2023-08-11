import java.util.*;

class Solution {
    
    public int solution(int[][] board) {
        
        int answer = 0;
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2];
        //dir 0 -> 가로  1 -> 세로
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0,0));
        visited[0][0][0] = true;
        int[][][] rotate = {{{-1,0},{-1,1},{0,0},{0,1}},{{0,-1},{1,-1},{0,0},{1,0}}};
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowDir = node.dir;
            int nowDis = node.dis;
            
           
            if(nowX==n-1&&nowY==n-2&&nowDir==0) return nowDis;
            if(nowX==n-2&&nowY==n-1&&nowDir==1) return nowDis;
            
            for(int i=0;i<4;i++){

                int nextX = nowX + rotate[nowDir][i][0];
                int nextY = nowY + rotate[nowDir][i][1];
                int nextDir = nowDir==0?1:0;
                if(rotate(nowX,nowY,nextX,nextY,board,visited,n,nowDir)&&valid(nextX,nextY,board,visited,n,nextDir)){
                    visited[nextX][nextY][nextDir] = true;
                    queue.add(new Node(nextX,nextY,nextDir,nowDis+1));
                }
            }   
            
            for(int i=0;i<4;i++){
                
                int nextX = nowX + d[i][0];
                int nextY = nowY + d[i][1];
                if(valid(nextX,nextY,board,visited,n,nowDir)){
                    visited[nextX][nextY][nowDir] = true;
                   queue.add(new Node(nextX, nextY, nowDir, nowDis+1));
                }
            }
            
        }
        
        return answer;
    }
    
    boolean valid(int x, int y, int[][] board, boolean[][][] visited, int n, int dir){
        
        if(x<0||x>n-1||y<0||y>n-1) return false;
        if(visited[x][y][dir]) return false;
        if(board[x][y]==1) return false;
        if(dir==1){
            if(x+1>n-1||board[x+1][y]==1) return false;   
        }
        if(dir==0) {
            if(y+1>n-1||board[x][y+1]==1) return false;
        }
        
        return true;
    }
    
    //0,0   
    boolean rotate(int x, int y, int nextX, int nextY, int[][] board, boolean[][][] visited, int n,int dir){
        
        if(x<0||x>n-1||y<0||y>n-1) return false;
        if(dir==0){
            if(y+1>n-1) return false;
            if(x>nextX){
                if(x-1<0) return false;
                if(board[x-1][y]==1||board[x-1][y+1]==1||board[x][y]==1||board[x][y+1]==1) return false;
            }else{
                if(x+1>n-1) return false;
                if(board[x][y]==1||board[x][y+1]==1||board[x+1][y]==1||board[x+1][y+1]==1) return false;
            }
        }else{
            if(x+1>n-1) return false;
            if(y>nextY){
                if(y-1<0) return false;
                if(board[x][y-1]==1||board[x][y]==1||board[x+1][y-1]==1||board[x+1][y]==1) return false;
            }else{
                if(y+1>n-1) return false;
                if(board[x][y]==1||board[x][y+1]==1||board[x+1][y]==1||board[x+1][y+1]==1) return false;
            }
        }
        return true;
    }
}
class Node{
    int x, y, dir, dis;
    Node(int x, int y, int dir, int dis){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.dis = dis;
    }
} 