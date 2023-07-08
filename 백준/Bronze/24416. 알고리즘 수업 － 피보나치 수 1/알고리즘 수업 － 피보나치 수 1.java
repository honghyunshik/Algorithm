
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int f1 = 0;
    static int f2 = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        System.out.println(f1 + " " + (n-2));

    }

    public static int fib(int n){

        if(n==1||n==2) {
            f1++;
            return 1;
        }

        return fib(n-2) + fib(n-1);
    }

    //5 = 4 + 3 -> 1
    //4 = 3 + 2 -> 2
    //3 = 2 + 1 -> 3


}
