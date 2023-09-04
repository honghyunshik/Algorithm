import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static int[][] BOARD;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        BOARD = new int[R][C];

        for(int i=0;i<R;i++){
            String input = br.readLine();
            for(int j=0;j<C;j++){
                BOARD[i][j] = input.charAt(j)-48;
            }
        }

        int[][] dp = new int[R+1][C+1];

        for(int i=1;i<=R;i++){

            for(int j=1;j<=C;j++){

                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + BOARD[i-1][j-1];
            }
        }



        for(int i=1;i<=R;i++){

            for(int j=1;j<=C;j++){

                if(BOARD[i-1][j-1]==1){
                    answer = Math.max(answer,1);
                    int dis = 2;
                    int nextL = i+1;
                    int nextR = j+1;

                    while(can(nextL,nextR)){

                        if(dp[nextL][nextR]-dp[i-1][nextR]-dp[nextL][j-1]+dp[i-1][j-1]==dis*dis){
                            answer = Math.max(answer,dis*dis);
                            dis++;
                            nextL++;
                            nextR++;
                        }else break;
                    }
                }
                
            }
        }

        System.out.println(answer);
    }

    static boolean can(int l, int r){
        if(l<0||l>R||r<0||r>C) return false;
        return true;
    }

}
