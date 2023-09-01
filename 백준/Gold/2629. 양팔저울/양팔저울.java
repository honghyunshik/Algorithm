
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] can;
    static int[] chu;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        chu = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            chu[i] = Integer.parseInt(st.nextToken());
        }
        num = Integer.parseInt(br.readLine());
        int[] ball = new int[num];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            ball[i] = Integer.parseInt(st.nextToken());
        }

        can = new boolean[15001];
        can[0] = true;

        for(int i=0;i<chu.length;i++){

            HashSet<Integer> list = new HashSet<>();
            for(int j=0;j<can.length;j++){

                if(can[j]){

                    if(j + chu[i]<=15000&&!can[j+chu[i]]) list.add(j + chu[i]);
                    if(!can[Math.abs(j-chu[i])]) list.add(Math.abs(j-chu[i]));
                }
            }
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                int next = iterator.next();
                can[next] = true;
            }

        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ball.length;i++){

            if(ball[i]>15000) sb.append("N ");
            else if(!can[ball[i]]) sb.append("N ");
            else sb.append("Y ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }


}
