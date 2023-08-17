import java.util.*;

class Solution {
    
    HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();
    boolean[] VISITED;
    int[][] BOARD;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board, int r, int c) {
        
        
        BOARD = board;
        int max = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==0) continue;
                max = Math.max(max,board[i][j]);
                ArrayList<int[]> list = map.getOrDefault(board[i][j],new ArrayList<>());
                list.add(new int[]{i,j});
                map.put(board[i][j],list);
            }
        }
        VISITED = new boolean[max+1];
        for(int i=1;i<=max;i++){
            VISITED[i] = true;
            dfs(r,c,i,0);
            VISITED[i] = false;
        }
        
        
       
        
        
        return answer;
    }
    
    void dfs(int x, int y, int num, int dis){
        
        ArrayList<int[]> list = map.get(num);
        
        int leftX = list.get(0)[0];
        int leftY = list.get(0)[1];
        int rightX = list.get(1)[0];
        int rightY = list.get(1)[1];
        
        int lTor = getDis(x,y,leftX,leftY) + getDis(leftX,leftY,rightX,rightY) + 2;
        int rTol = getDis(x,y,rightX,rightY) + getDis(rightX,rightY,leftX,leftY) + 2;
        
    
  
        
        boolean flag = false;
        for(int i=1;i<VISITED.length;i++){
            
            if(i!=num&&!VISITED[i]){
                flag = true;
                VISITED[i] = true;
                dfs(leftX,leftY,i,dis + rTol);
                dfs(rightX,rightY,i,dis + lTor);
                VISITED[i] = false;
            }
        }
        if(!flag){
            answer = Math.min(answer,dis + Math.min(lTor,rTol));
        }
    }
    
    int getDis(int x, int y, int X, int Y){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDis = now[2];
            if(nowX==X&&nowY==Y) return nowDis;
            
            for(int i=0;i<4;i++){
                
                int nextX = nowX + d[i][0];
                int nextY = nowY + d[i][1];
                if(nextX<0||nextX>3||nextY<0||nextY>3) continue;
                queue.add(new int[]{nextX,nextY,nowDis+1});
              
                while(nextX+d[i][0]>=0&&nextX+d[i][0]<=3&&nextY+d[i][1]>=0&&nextY+d[i][1]<=3&&(BOARD[nextX][nextY]==0||VISITED[BOARD[nextX][nextY]])&&(nextX!=X||nextY!=Y)){
                    nextX += d[i][0];
                    nextY += d[i][1];
                }
                
                 if(nowX+d[i][0]!=nextX||nowY+d[i][1]!=nextY) queue.add(new int[]{nextX,nextY,nowDis+1});
              
            }
        }
        
        return -1;
    }
}