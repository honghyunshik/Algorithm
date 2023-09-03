
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = (int) ((long)y*100/x);
        if(z>=99){
            System.out.println(-1);
        }else{

            z++;
            int l = 0, r = x;


            while(l<r){
                int mid = (l+r)/2;
                if((long)(y+mid)*100/(x+mid)<z){
                    l = mid+1;
                }else r = mid;
            }
            System.out.println(l);
        }
    }
}
