import java.util.*;
class Solution {
    
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    boolean[][] visited;
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] PICTURE;
    int N,M;
    
    public int[] solution(int m, int n, int[][] picture) {
        
       
        visited = new boolean[m][n];
        PICTURE = picture;
        M = m;
        N = n;
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&PICTURE[i][j]!=0){
                    visited[i][j] = true;
                    numberOfArea++;
                    int cnt = dfs(i,j,picture[i][j]);
                    System.out.println("i : " + i + " j : " + j + " cnt : " + cnt);
                    maxSizeOfOneArea = Math.max(cnt,maxSizeOfOneArea);
                }
            }
        }

       
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }
    
    private int dfs(int l, int r, int val){
        
        int sum = 0;
        for(int i=0;i<4;i++){
            
            int nextL = l + D[i][0];
            int nextR = r + D[i][1];
            if(nextL<0||nextL>M-1||nextR<0||nextR>N-1) continue;
            if(!visited[nextL][nextR]&&PICTURE[nextL][nextR]==val){
                visited[nextL][nextR] = true;
                sum += dfs(nextL,nextR,val);
            }
        }
        
        return sum+1;
    }
    
}