
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.get(l).add(r);
            list.get(r).add(l);
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int n){

        visited[n] = true;
        for(int i=0;i<list.get(n).size();i++){

            int next = list.get(n).get(i);
            if(!visited[next]) dfs(next);
        }
    }
}
