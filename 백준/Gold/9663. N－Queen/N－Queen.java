
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        boolean[] visitied = new boolean[n+1];
        brute(1,arr,n,visitied);
        System.out.println(answer);
    }

    public static void brute(int idx, int[] arr, int n, boolean[] visited){

        if(idx>n){
            answer++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                boolean flag = true;
                for(int j=1;j<idx;j++){
                    if(idx-j==Math.abs(arr[j]-i)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    visited[i] = true;
                    arr[idx] = i;
                    brute(idx+1,arr,n,visited);
                    visited[i] = false;
                }
            }
        }
    }
}
