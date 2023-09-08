package org.example.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra_past {

    public static int[] dijkstra(int[][] board, int N, int M, int start){

        int MAX = 9999999;
        int[] dis = new int[N+1];
        Arrays.fill(dis,MAX);
        dis[start] = 0;
        boolean[] visited = new boolean[N+1];
        for(int i=0;i<N;i++){
            int idx = getMin(N,visited,dis);
            visited[idx] = true;
            for(int j=1;j<=N;j++){
                dis[j] = Math.min(dis[idx] + board[idx][j],dis[j]);
            }
        }
        return dis;
    }
    public static int getMin(int N, boolean[] visited, int[] dis){

        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i=1;i<=N;i++){

            if(!visited[i]&&dis[i]<minVal){
                minVal = dis[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

}
