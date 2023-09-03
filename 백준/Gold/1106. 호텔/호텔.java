
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1]  =Integer.parseInt(st.nextToken());
        }
        int MAX = 9999999;
        int[] dp = new int[c+1];
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        for(int i=0;i<n;i++){

            for(int j=0;j<=c;j++){

                if(j<arr[i][1]) dp[j] = Math.min(dp[j],arr[i][0]);
                else dp[j] = Math.min(dp[j],dp[j-arr[i][1]] + arr[i][0]);
            }

        }
        System.out.println(dp[c]);
    }
}
