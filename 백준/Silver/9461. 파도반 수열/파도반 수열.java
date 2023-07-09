import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(tri(n));
        }

    }
    public static long tri(int n){

        if(n<5){
            if(n<=3) return 1;
            return 2;
        }
        long[] dp = new long[n+1];
        for(int i=1;i<=5;i++){
            if(i<=3) dp[i] = 1;
            else dp[i] = 2;
        }
        for(int i=6;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
        return dp[n];
    }
}
