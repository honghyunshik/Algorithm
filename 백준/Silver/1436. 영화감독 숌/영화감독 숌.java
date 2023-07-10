import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 666;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        while(cnt!=n){
            if(Integer.toString(start).contains("666")) cnt++;
            start++;
        }
        System.out.println(start-1);

    }


}
