
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] build;
    static ArrayList<ArrayList<Integer>> list;
    static int[] child;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            build = new int[n+1];
            child = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                build[j] = Integer.parseInt(st.nextToken());
            }
            list = new ArrayList<>();
            for(int j=0;j<=n;j++){
                list.add(new ArrayList<>());
            }

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                child[r]++;
                list.get(l).add(r);
            }
            int w = Integer.parseInt(br.readLine());
            System.out.println(getMin(n,w));
        }
    }

    private static int getMin(int n, int w){

        int[] stack = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(child[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){


            int now = queue.poll();
            //System.out.println("now : " + now);
            stack[now] = Math.max(build[now],stack[now]);
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i);
                child[next]--;
                if(child[next]==0) queue.add(next);
                stack[next] = Math.max(stack[next],stack[now]+build[next]);
            }
        }
        return stack[w];
    }

}
