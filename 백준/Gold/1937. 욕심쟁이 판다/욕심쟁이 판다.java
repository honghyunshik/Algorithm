
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int n;

    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                answer = Math.max(answer,dfs(i,j));
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int l, int r){

        board[l][r]--;
        int max = 1;
        for(int i=0;i<4;i++){

            int nextL = l + D[i][0];
            int nextR = r + D[i][1];
            if(nextL<0||nextL>n-1||nextR<0||nextR>n-1) continue;
            if(board[l][r]+1<board[nextL][nextR]){
                if(dp[nextL][nextR]==-1) max = Math.max(max,dfs(nextL,nextR)+1);
                else max = Math.max(max,dp[nextL][nextR]+1);
            }
        }

        board[l][r]++;
        return dp[l][r] = max;
    }
}
