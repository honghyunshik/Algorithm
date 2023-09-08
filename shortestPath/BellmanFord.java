package org.example.shortestPath;

import java.util.Arrays;

public class BellmanFord {

    public static int[] bellmanFord(int[][] board, int V, int E, int start){

        int[] dis = new int[V+1];
        int MAX = 9999999;
        Arrays.fill(dis,MAX);
        dis[start] = 0;

        for(int i=0;i<V;i++){
            for(int j=0;j<E;j++){
                dis[board[j][1]] = Math.min(dis[board[j][1]],dis[board[j][0]] + board[j][2]);
            }
        }
        //음수 간선 체크
        for(int i=0;i<E;i++){
            System.out.println(Arrays.toString(board[i]));
            if(dis[board[i][1]]>dis[board[i][0]] + board[i][2]) return null;
        }
        return dis;
    }
}
