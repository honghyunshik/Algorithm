
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int T=0;T<t;T++){
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            System.out.println(all(coin,target));
        }
    }

    static int all(int[] coin, int target){

        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=0;i<coin.length;i++){

            for(int j=coin[i];j<=target;j++){

                dp[j] += dp[j-coin[i]];
            }
        }
        return dp[target];
    }
}
