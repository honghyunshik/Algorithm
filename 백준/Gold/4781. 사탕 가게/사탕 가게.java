import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) (Double.parseDouble(st.nextToken())*100+0.5);
            if(n==0&&m==0) break;
            int[] calory = new int[n];
            int[] price = new int[n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                calory[i] = Integer.parseInt(st.nextToken());
                price[i] = (int) (Double.parseDouble(st.nextToken())*100+0.5);
            }
            int[] dp = new int[m+1];
            for(int i=0;i<n;i++){

                for(int j=price[i];j<=m;j++){

                    dp[j] = Math.max(dp[j],dp[j-price[i]] + calory[i]);
                }
            }
            System.out.println(dp[m]);

        }
    }
}
