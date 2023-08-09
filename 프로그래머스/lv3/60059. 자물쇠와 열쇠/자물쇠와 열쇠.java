import java.util.*;
class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        
        boolean answer = true;
        int n = key.length;
        int m = lock.length;
        int[][] key_1 = new int[n][n];      //시계방향 90도 회전
        int[][] key_2 = new int[n][n];      //시계방향 180도 회전
        int[][] key_3 = new int[n][n];      //시계방향 270도 회전
        toRight(key,key_1,n);
        toRight(key_1,key_2,n);
        toRight(key_2,key_3,n);
        int lockCnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(lock[i][j]==0) lockCnt++;
            }
        }
        boolean[][] visited = new boolean[m+n-1][m+n-1];
        int k = m+n-1;
        
        int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            
            int[] now = queue.poll();
            int l = now[0];
            int r = now[1];
            
            int kstartL = Math.max(0,n-l-1);
            int kstartR = Math.max(0,n-r-1);
            int kendL = Math.min(n,k-l);
            int kendR = Math.min(n,k-r);
            
            int lstartL = Math.max(0,l-n+1);
            int lstartR = Math.max(0,r-n+1);
            int lendL = Math.min(l+1,m);
            int lendR = Math.min(r+1,m);
            
            if(isFit(kstartL,kstartR,kendL,kendR,lstartL,lstartR,lendL,lendR,key,lock,lockCnt)) return true;
            if(isFit(kstartL,kstartR,kendL,kendR,lstartL,lstartR,lendL,lendR,key_1,lock,lockCnt)) return true;
            if(isFit(kstartL,kstartR,kendL,kendR,lstartL,lstartR,lendL,lendR,key_2,lock,lockCnt)) return true;
            if(isFit(kstartL,kstartR,kendL,kendR,lstartL,lstartR,lendL,lendR,key_3,lock,lockCnt)) return true;
            
            for(int i=0;i<4;i++){
                int nextL = l+D[i][0];
                int nextR = r+D[i][1];
                if(nextL<0||nextL>k-1||nextR<0||nextR>k-1) continue;
                if(visited[nextL][nextR]) continue;
                visited[nextL][nextR] = true;
                queue.add(new int[]{nextL,nextR});
            }
            
        }
        
        return false;
    }
    
    private boolean isFit(int astartL,int astartR, int aendL, int aendR,
                         int bstartL, int bstartR, int bendL, int bendR,  int[][] key, int[][] lock, int target){
        
        int temp = bstartR;
        int cnt = 0;
        for(int i=astartL;i<aendL;i++){
            bstartR = temp;
            for(int j=astartR;j<aendR;j++){
                if(key[i][j]==lock[bstartL][bstartR++]) return false;
                if(key[i][j]==1) cnt++;
            }
            bstartL++;
        }
        if(cnt==target) return true;
        
        
        return false;
    }
    
    private void toRight(int[][] arr1, int[][] arr2, int n){
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr2[j][n-1-i] = arr1[i][j];
            }
        }
    }
}