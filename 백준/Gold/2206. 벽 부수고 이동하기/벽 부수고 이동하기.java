
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] MAP;
    static boolean[][][] VISITED;
    static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][M];
        VISITED = new boolean[2][N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                MAP[i][j] = input.charAt(j)-48;
            }
        }

        System.out.println(bfs());




    }

    public static int bfs(){

        class Pointer{
            int l, r,dis;
            boolean used;
            Pointer(int l, int r, boolean used, int dis){
                this.l = l;
                this.r = r;
                this.used = used;
                this.dis = dis;
            }
        }

        Queue<Pointer> queue = new LinkedList<>();
        VISITED[0][0][0] = true;
        queue.add(new Pointer(0,0,false,1));
        while(!queue.isEmpty()){

            Pointer curr = queue.remove();
            if(curr.l==N-1&&curr.r==M-1) return curr.dis;
            for(int i=0;i<4;i++){
                int nextL = curr.l + D[i][0];
                int nextR = curr.r + D[i][1];
                if(nextL<0||nextL>N-1||nextR<0||nextR>M-1) continue;
                if(VISITED[0][nextL][nextR]) continue;
                if(VISITED[1][nextL][nextR]&&curr.used) continue;
                if(MAP[nextL][nextR]==1&&!curr.used)  queue.add(new Pointer(nextL,nextR,true,curr.dis+1));
                if(MAP[nextL][nextR]==1) continue;
                if(curr.used) VISITED[1][nextL][nextR] = true;
                if(!curr.used){
                    VISITED[0][nextL][nextR] = true;
                    VISITED[1][nextL][nextR] = true;
                }
                queue.add(new Pointer(nextL, nextR, curr.used, curr.dis+1));
            }

        }

        return -1;
    }
}
