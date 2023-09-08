package org.example.shortestPath;

public class FloydWarshall {

    public static int[][] floydWarshall(int[][] board, int N, int M){

        for(int i=1;i<=N;i++){

            for(int j=1;j<=N;j++){

                for(int k=1;k<=N;k++){

                    board[j][k] = Math.min(board[j][k],board[j][i] + board[i][k]);
                }
            }
        }
        //음수 사이클 탐지
        for(int i=1;i<=N;i++){
            if(board[i][i]<0) return null;
        }
        return board;
    }
}
