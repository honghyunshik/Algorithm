import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getMin(n));
    }

    private static int getMin(int n){

        int cnt5 = n/5;
        int left = n-cnt5*5;
        while(cnt5>=0){

            if(left%3==0) return cnt5 + left/3;
            cnt5--;
            left+=5;
        }

        return -1;
    }

}
