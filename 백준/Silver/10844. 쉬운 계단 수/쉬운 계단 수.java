
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][10];

        for(int i=1;i<10;i++){
            dp[0][i] = 1;
        }
        int DIV = 1000000000;
        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j+1]%DIV;
                }else if(j==9){
                    dp[i][j] = dp[i-1][j-1]%DIV;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%DIV;
                }

            }
        }
        long answer = 0;
        for(int i=0;i<10;i++){
            answer += dp[n-1][i];
            answer %= 1000000000;
        }
        System.out.println(answer);

    }
}
