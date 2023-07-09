
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int[][] bag = new int[n][2];
        for(int i=0;i<n;i++){

            st= new StringTokenizer(br.readLine()," ");
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[weight+1];


        for(int i=0;i<n;i++){

            int now_weight = bag[i][0];
            int now_value = bag[i][1];

            for(int j = weight;j>=now_weight;j--){
                dp[j] = Math.max(dp[j],dp[j-now_weight] + now_value);
            }
        }
        System.out.println(dp[weight]);
    }
}
