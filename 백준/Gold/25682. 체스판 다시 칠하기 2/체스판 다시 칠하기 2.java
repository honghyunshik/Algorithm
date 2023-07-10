
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = input.charAt(j);
            }
        }
        int[][] dif = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i%2==0){
                    if(j%2==0){
                        if(board[i][j]=='W') dif[i][j] = 1;
                    }else{
                        if(board[i][j]=='B') dif[i][j] = 1;
                    }
                }else{
                    if(j%2==0){
                        if(board[i][j]=='B') dif[i][j] = 1;
                    }else{
                        if(board[i][j]=='W') dif[i][j] = 1;
                    }
                }
            }
        }


        int[][] sum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){

            for(int j=1;j<=m;j++){

                sum[i][j] = dif[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int answer = Integer.MAX_VALUE;
   
        for(int i=1;i<=n-k+1;i++){

            for(int j=1;j<=m-k+1;j++){

                answer = Math.min(getSum(i,j,k,sum),answer);
            }
        }
        System.out.println(answer);
    }

    public static int getSum(int l, int r, int k, int[][] sum){

        int ans = sum[l+k-1][r+k-1] - sum[l-1][r+k-1] - sum[l+k-1][r-1] + sum[l-1][r-1];
        return Math.min(ans,k*k-ans);
    }
}
