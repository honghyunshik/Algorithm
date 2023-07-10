import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] grape = new int[n];
        for(int i=0;i<n;i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(wine(grape,n));
    }

    public static int wine(int[] grape, int n){
        int[] dp = new int[n];
        dp[0] = grape[0];
        if(n>1)dp[1] = grape[0] + grape[1];
        if(n>2)dp[2] = Math.max(dp[1],Math.max(grape[0] + grape[2],grape[1] + grape[2])) ;


        for(int i=3;i<n;i++){
            dp[i] = Math.max(dp[i-3] + grape[i-1],dp[i-2]) + grape[i];
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
        return dp[n-1];
    }
}

