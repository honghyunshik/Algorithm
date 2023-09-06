import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static int N,M;
    static int answer = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for(int i=0;i<N;i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<N;i++){

            for(int j=0;j<M;j++){

                for(int x=-N;x<N;x++){

                    for(int y=-M;y<M;y++){
                        if(x==0&&y==0) continue;
                        dfs(i,j,x,y,"");
                    }
                }
            }
        }
        System.out.println(answer);

    }

    static void dfs(int nowX, int nowY, int plusX, int plusY, String val){

        if(!isIn(nowX,nowY)) return;
        val += board[nowX][nowY];
        if(isDouble(Integer.parseInt(val))) answer = Math.max(answer,Integer.parseInt(val));
        dfs(nowX+plusX,nowY+plusY,plusX,plusY,val);
    }

    static boolean isIn(int l, int r){
        if(l<0||l>N-1||r<0||r>M-1) return false;
        return true;
    }

    static boolean isDouble(int num){

        double temp = Math.sqrt(num);
        if(temp%1==0&&temp*temp==num) return true;
        return false;
    }
}
