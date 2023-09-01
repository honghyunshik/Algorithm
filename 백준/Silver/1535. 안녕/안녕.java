
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];


        for(int i=0;i<n;i++){

            for(int j=100;j>arr[i][0];j--){

                dp[j] = Math.max(dp[j],dp[j-arr[i][0]] + arr[i][1]);
            }
        }
        System.out.println(dp[100]);
    }
}
