import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[][][] visited = new boolean[n][n][4];
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        pq.add(new Node(0,0,0,0));
        pq.add(new Node(0,0,0,1));
        //0 오른쪽 1 아래 2 왼쪽 3 위
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!pq.isEmpty()){
            
            Node node = pq.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowCost = node.cost;
            int nowDir = node.dir;
            visited[nowX][nowY][nowDir] = true;
            if(nowX==n-1&&nowY==n-1) return nowCost;
            for(int i=0;i<4;i++){
                
                int nextX = nowX + d[i][0];
                int nextY = nowY + d[i][1];
                if(nextX<0||nextX>n-1||nextY<0||nextY>n-1) continue;
                if(board[nextX][nextY]==1) continue;
                if(!visited[nextX][nextY][i]){
                    if(i==nowDir) pq.add(new Node(nextX,nextY,nowCost+100,i));
                    else pq.add(new Node(nextX, nextY, nowCost+600,i));
                }
                
               
            }
            
        }
        return -1;
    }
}   

class Node{
    
    int x,y,cost,dir;
    Node(int x, int y, int cost,int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}