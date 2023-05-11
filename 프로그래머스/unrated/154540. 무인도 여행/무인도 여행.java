import java.util.*;
class Solution {
    
    static boolean[][] visited;
    static char[][] MAP;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    static int sum=0;
    static int N,M;
    
    public int[] solution(String[] maps) {
    
        N = maps.length;
        M = maps[0].length();
        ArrayList<Integer> list = new ArrayList<>();
        MAP = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                MAP[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&MAP[i][j]!='X'){
                    dfs(i,j);
                    list.add(sum);
                    sum = 0;
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
         for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private void dfs(int l, int r){
        
        sum += MAP[l][r]-48;
        visited[l][r] = true;
        
        for(int i=0;i<4;i++){
            
            int nextL = l + D[i][0];
            int nextR = r + D[i][1];
            
            if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
            if(visited[nextL][nextR]) continue;
            if(MAP[nextL][nextR]=='X') continue;
            dfs(nextL,nextR);
        }
        
    }
    
}