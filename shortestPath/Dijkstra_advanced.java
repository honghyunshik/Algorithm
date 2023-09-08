package org.example.shortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_advanced {

    public static int[] dijkstra(int[][] board, int N, int M, int start){

        //최단거리 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        int[] dis = new int[N+1];
        int MAX = 9999999;
        Arrays.fill(dis,MAX);
        dis[start] = 0;
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){

            int[] now = pq.poll();
            int nowIdx = now[0];
            int nowDis = now[1];
            for(int i=1;i<=N;i++){

                if(!visited[i]&&dis[i]>nowDis+board[nowIdx][i]){
                    visited[i] = true;
                    dis[i] = nowDis + board[nowIdx][i];
                    pq.add(new int[]{i,dis[i]});
                }
            }
        }
        return dis;
    }
}
