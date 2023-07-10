
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static char[][] BOARD;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BOARD = new char[n][m];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                BOARD[i][j] = input.charAt(j);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                answer = Math.min(brute(i,j,i+8,j+8),answer);
            }
        }
        System.out.println(answer);
    }

    public static int brute(int startL, int startR, int finL, int finR){

        int change = 0;
        HashMap<Integer,Character> map = new HashMap<>();
        map.put(1,'B');
        map.put(-1,'W');
        int start = 1;
        for(int i=startL;i<finL;i++){
            for(int j=startR;j<finR;j++){
                if(BOARD[i][j]==map.get(start)){
                    change++;
                }
                start *=-1;
            }
            start *= -1;
        }
        return Math.min(change,64-change);
    }
}
