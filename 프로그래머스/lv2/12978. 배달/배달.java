import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        int answer = 0;
        
        int[][] ROAD = new int[N+1][N+1];
        int INF = 999999;
        
        for(int i=1;i<=N;i++){
            Arrays.fill(ROAD[i],INF);
        }
        
        for(int[] arr:road){
            
            int l = arr[0];
            int r = arr[1];
            int dis = arr[2];
            if(ROAD[l][r]>dis){
                ROAD[l][r] = dis;
                ROAD[r][l] = dis;
            }
            
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            
            Node node = pq.poll();
            int val = node.val;
            int dis = node.dis;
              
            for(int i=1;i<=N;i++){
                if(i==val) continue;
                
                if(dist[i]>dis + ROAD[val][i]){
                    dist[i] = dis + ROAD[val][i];
                    pq.add(new Node(i,dist[i]));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }
}

class Node{
    
    int val, dis;
    Node(int val, int dis){
        this.val = val;
        this.dis = dis;
    }
}