import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int N = board.length, M = board[0].length;
        int[][] total = new int[N+1][M+1];
        for(int[] arr:skill){
            if(arr[0]==1) arr[5] = -arr[5];
            total[arr[1]][arr[2]] += arr[5];
            total[arr[1]][arr[4]+1] -= arr[5];
            total[arr[3]+1][arr[2]] -= arr[5];
            total[arr[3]+1][arr[4]+1] += arr[5];
        }
        
        //상하 합
        //N = 세로  M = 가로
        for(int i=0;i<M;i++){
            for(int j=1;j<N;j++){
                total[j][i] += total[j-1][i];
            }
        }
        
        //좌우 합
        for(int i=0;i<N;i++){
            for(int j=1;j<M;j++){
                total[i][j] += total[i][j-1];
            }
        }
        
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]+total[i][j]>0) answer++;
            }
        }
        
        
        
        return answer;
    }
}