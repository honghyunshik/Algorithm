
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[][] d;
    static ArrayList<ArrayList<Integer>> list;

    static int answer = 0;

    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<n*m;i++){
            list.add(new ArrayList<>());
        }
        board = new int[n][m];
        dp = new int[n*m];
        Arrays.fill(dp,-1);
        d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int idx = i*m+j;
                if(i==n-1&&j==m-1){
                    list.get(idx).add(-1);
                }else {
                    for (int p = 0; p < 4; p++) {
                        int nextI = i + d[p][0];
                        int nextJ = j + d[p][1];
                        if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1) continue;
                        if (board[i][j]>board[nextI][nextJ]) list.get(idx).add(nextI*m+nextJ);
                    }
                }
            }
        }


        System.out.println(dfs(0));
    }

    private static int dfs(int n){

        if(!list.get(n).isEmpty()&&list.get(n).get(0)==-1){
            return dp[n] = 1;
        }
        int sum = 0;
        for(int i=0;i<list.get(n).size();i++){
            int next = list.get(n).get(i);
            if(dp[next]==-1){
                sum += dfs(next);
            }else sum += dp[next];
        }

        return dp[n] = sum;
    }



}
