
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int len = Integer.MAX_VALUE, start = -1;

        int x = 0, y = 0; long sum = 0;

        while(y<=n){

            if(sum>n){
                sum -= x;
                x++;
            }
            else if(sum<n) {
                y++;
                sum += y;
            }
            else{
                int tempLen = y-x+1;
                if(tempLen>=l&&tempLen<=100&&tempLen<len){
                    len = tempLen;
                    start = x;
                }
                sum-=x;
                x++;
            }
        }

        if(start==-1) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for(int i = start;i<start+len;i++){
                sb.append(i + " ");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }





    }


}
