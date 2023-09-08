package org.example.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        int[][] edge = new int[len*2][3];
        int MAX = 9999999;
        for(int i=0;i<=N;i++){
            Arrays.fill(board[i],MAX);
            board[i][i] = 0;
        }
        int idx = 0;
        for(int i=0;i<len;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            board[l][r] = dis;
            board[r][l] = dis;
            edge[idx++] = new int[]{l,r,dis};
            edge[idx++] = new int[]{r,l,dis};
        }
        //input

        /*
        System.out.println(Arrays.toString(Dijkstra_past.dijkstra(board,N,M,start)));
        System.out.println(Arrays.toString(Dijkstra_advanced.dijkstra(board,N,M,start)));
        System.out.println(Arrays.toString(BellmanFord.bellmanFord(edge,N,len*2,start)));
        */

        int[][] ans = FloydWarshall.floydWarshall(board,N,M);
        for(int i=1;i<=N;i++){
            System.out.println(Arrays.toString(ans[i]));
        }



    }
}
