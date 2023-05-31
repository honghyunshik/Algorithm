
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static ArrayList<ArrayList<Integer>> list;

    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] cnt;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.get(l).add(r);
        }
        String answer = "";
        cnt = new int[n+1];
        for(int i=1;i<=n;i++){
            dfs(i);
        }
        for(int i=1;i<=n;i++){

            if(max==cnt[i]) answer += i + " ";
        }
        System.out.println(answer);

    }

    private static void dfs(int st){

        visited = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        visited[st] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            max = Math.max(max,++cnt[now]);
            for(int i=0;i<list.get(now).size();i++){

                int next = list.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }




    }
}
