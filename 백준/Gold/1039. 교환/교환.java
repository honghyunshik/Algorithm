import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[k+1][1000001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{num,0});
        int answer = -1;
        int len = String.valueOf(num).length();
        while(!queue.isEmpty()){

            int[] now = queue.poll();
            if(now[1]==k){
                answer = Math.max(answer,now[0]);
                continue;
            }
            for(int i=0;i<len;i++){

                for(int j=i+1;j<len;j++){

                    int next = swap(now[0],i,j);
                    if(next!=0&&!visited[now[1]+1][next]){
                        visited[now[1]+1][next] = true;
                        queue.add(new int[]{next,now[1]+1});
                    }
                }
            }
        }
        System.out.println(answer);

    }

    static int swap(int num, int l, int r){

        char[] arr = String.valueOf(num).toCharArray();
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        if(arr[0]=='0') return 0;
        return Integer.parseInt(new String(arr));
    }
}
