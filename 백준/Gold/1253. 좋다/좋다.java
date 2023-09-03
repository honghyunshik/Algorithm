
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0;i<n;i++){

            int l = 0 , r = n-1;
            while(l<r){

                if(l==i) l++;
                if(r==i) r--;
                if(l>=r) break;
                int sum  =arr[l] + arr[r];
                if(sum<arr[i]) l++;
                else if(sum>arr[i]) r--;
                else{
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
