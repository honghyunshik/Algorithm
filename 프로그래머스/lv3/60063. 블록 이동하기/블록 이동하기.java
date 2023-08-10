import java.util.*;
class Solution {
    public int solution(int[][] board) {
        
        int n = board.length;
        Queue<Node> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][n][n][n];
        queue.add(new Node(0,0,0,1,0));
        int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            
            Node now = queue.poll();
            
            int startL = now.startL;
            int startR = now.startR;
            int endL = now.endL;
            int endR = now.endR;
            int dis = now.dis;
            
            //System.out.println((endL-startL) + " " + (endR-startR));
            
            if((startL==n-1&&startR==n-1)||(endL==n-1&&endR==n-1)){
                return dis;
            }
            
            //오른쪽으로 일자일때
            if(startL==endL){
                
                //위로 회전할 수 있을 때
                if(startL>0&&board[startL-1][startR]==0&&board[startL-1][endR]==0){
                    
                    //방문 안했을 때
                    if(!visited[startL-1][startR][startL][startR]){
                        visited[startL-1][startR][startL][startR] = true;
                        queue.add(new Node(startL-1,startR,startL,startR,dis+1));
                    }
                    if(!visited[startL-1][endR][startL][endR]){
                        visited[startL-1][endR][startL][endR] = true;
                        queue.add(new Node(startL-1,endR,startL,endR,dis+1));
                    }
                }
                
                //아래로 회전할 수 있을 때
                if(startL<n-1&&board[startL+1][startR]==0&&board[startL+1][endR]==0){
                    
                    //방문 안했을 때
                    if(!visited[startL][startR][startL+1][startR]){
                        visited[startL][startR][startL+1][startR] = true;
                        queue.add(new Node(startL,startR,startL+1,startR,dis+1));
                    }
                    if(!visited[startL][endR][startL+1][endR]){
                        visited[startL][endR][startL+1][endR] = true;
                        queue.add(new Node(startL,endR,startL+1,endR,dis+1));
                    }
                        
                }
            }
            //아래로 일자일 때
            else if(startR==endR){
                
                //왼쪽으로 회전할 때
                if(startR>0&&board[startL][startR-1]==0&&board[endL][startR-1]==0){
                    
                    if(!visited[startL][startR-1][startL][startR]){
                        visited[startL][startR-1][startL][startR] = true;
                        queue.add(new Node(startL,startR-1,startL,startR,dis+1));
                    }
                    if(!visited[endL][startR-1][endL][startR]){
                        visited[endL][startR-1][endL][startR] = true;
                        queue.add(new Node(endL,startR-1,endL,startR,dis+1));
                    }
                }
                //오른쪽으로 회전할 때
                if(startR<n-1&&board[startL][startR+1]==0&&board[endL][startR+1]==0){
                    
                    if(!visited[startL][startR][startL][startR+1]){
                        visited[startL][startR][startL][startR+1] = true;
                        queue.add(new Node(startL,startR,startL,startR+1,dis+1));
                    }
                    
                    if(!visited[endL][startR][endL][startR+1]){
                        visited[endL][startR][endL][startR+1] = true;
                        queue.add(new Node(endL,startR,endL,startR+1,dis+1));
                    }
                }
            }
            
            for(int i=0;i<4;i++){
                
                int nextSL = startL + D[i][0];
                int nextEL = endL + D[i][0];
                int nextSR = startR + D[i][1];
                int nextER = endR + D[i][1];
                if(nextSL<0||nextSL>n-1||nextEL<0||nextEL>n-1
                  ||nextSR<0||nextSR>n-1||nextER<0||nextER>n-1) continue;
                if(visited[nextSL][nextSR][nextEL][nextER]) continue;
                if(board[nextSL][nextSR]==1||board[nextEL][nextER]==1) continue;
                visited[nextSL][nextSR][nextEL][nextER] = true;
                queue.add(new Node(nextSL,nextSR,nextEL,nextER,dis+1));
            }
            
        }
       
        return -1;
    }
}

class Node{
    
    int startL, startR, endL, endR, dis;
    Node(int startL, int startR, int endL, int endR, int dis){
        this.startL = startL;
        this.startR = startR;
        this.endL = endL;
        this.endR = endR;
        this.dis = dis;
    }
    
}