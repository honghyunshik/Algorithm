
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = makeSum(board);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            System.out.println(getSum(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),sum));
        }
    }

    public static int[][] makeSum(int[][] board){

        int[][] sum = new int[board.length+1][board.length+1];
        for(int i=1;i<=board.length;i++){

            for(int j=1;j<=board.length;j++){

                sum[i][j] = board[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        return sum;
    }

    public static int getSum(int startL, int startR, int finL, int finR,int[][] sum){

        return sum[finL][finR] - sum[finL][startR-1] - sum[startL-1][finR] + sum[startL-1][startR-1];
    }
}
