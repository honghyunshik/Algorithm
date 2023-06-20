import java.util.*;

class Solution {
    
    int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};
    HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();
    int[][] BOARD;
    boolean[] visited;
    int N,M;
    int cnt = 0;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board, int r, int c) {
        
        N = board.length;
        M = board[0].length;
        BOARD = board;
        for(int i=0;i<N;i++){
            
            for(int j=0;j<M;j++){
                
                if(board[i][j]!=0){
                    cnt++;
                    ArrayList<int[]> list = map.get(board[i][j]);
                    if(list==null){
                        list = new ArrayList<>();
                    }
                    list.add(new int[]{i,j});
                    map.put(board[i][j],list);
                }
            }
        }
         visited = new boolean[cnt/2+1];
       System.out.println(getDis(3,2,0,0));
        for(int i=1;i<=cnt/2;i++){
            
            visited[i] = true;
            dfs(i,r,c,0);
            visited[i] = false;
            
        }
       return answer;
    }
    
    private void dfs(int num, int x, int y, int dis){
        
      // System.out.println("num : " + num + " x : " + x + " y : " + y + 
        //                   " dis : "  + dis + " vis : " + Arrays.toString(visited));
        ArrayList<int[]> list = map.get(num);
        int x1 = list.get(0)[0];
        int y1 = list.get(0)[1];
        int x2 = list.get(1)[0];
        int y2 = list.get(1)[1];
        
        int x1Tox2 = getDis(x,y,x1,y1) + getDis(x1,y1,x2,y2) + 2;
        int x2Tox1 = getDis(x,y,x2,y2) + getDis(x2,y2,x1,y1) + 2;
        
        boolean flag = true;
        for(int i=1;i<=cnt/2;i++){
            
            if(!visited[i]){
                flag = false;
                visited[i] = true;
                dfs(i,x1,y1,dis+x2Tox1);
                dfs(i,x2,y2,dis+x1Tox2);
                visited[i] = false;
            }
        }
        if(flag){
            
            answer = Math.min(answer,dis + Math.min(x2Tox1,x1Tox2));
            return;
            
        }
        
    }
    
    private int getDis(int x1, int y1, int x2, int y2){
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x1,y1,0));
        
        while(!queue.isEmpty()){
            
            
            Node now = queue.poll();
             if(now.x==x2&&now.y==y2) return now.dis;
            
            for(int i=0;i<4;i++){
                
                int nextX = now.x + D[i][0];
                int nextY = now.y + D[i][1];
                int moreX = nextX;
                int moreY = nextY;
                
                if(!stop(nextX,nextY)) {
                    
                    queue.add(new Node(nextX,nextY,now.dis+1));
                    
                    while(!stop(moreX+D[i][0],moreY+D[i][1])&&!(BOARD[moreX][moreY]!=0&&!visited[BOARD[moreX][moreY]])
                         &&(moreX!=x2||moreY!=y2)){
                        moreX += D[i][0];
                        moreY += D[i][1];
                    }

                    if(moreX!=nextX||moreY!=nextY){
                        queue.add(new Node(moreX,moreY,now.dis+1));
                    }
                    
                }
                    
                
                
            }
              
        }
      
        return -1;
    }
    
    private boolean stop(int x, int y){
        
        if(x<0||x>N-1||y<0||y>M-1) return true;
        return false;
    }
}

class Node{
    
    int x, y, dis;
    Node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}