import java.util.*;

class Solution {
    
    int N;
    ArrayList<ArrayList<int[]>> LIST = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N = n;
        for(int i=0;i<=n;i++){
            LIST.add(new ArrayList<>());
        }
        for(int[] fare:fares){
            
            int l = fare[0];
            int r = fare[1];
            int cost = fare[2];
            LIST.get(l).add(new int[]{r,cost});
            LIST.get(r).add(new int[]{l,cost});
        }
        
        int[] with = dijkstra(s);
        int[] justA = dijkstra(a);
        int[] justB = dijkstra(b);
        for(int i=1;i<=n;i++){
            
            answer = Math.min(answer, with[i] + justA[i] + justB[i]);
            
        }
        return answer;
    }
    
  
    
    private int[] dijkstra(int a){

        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->p[1]-q[1]);
        pq.add(new int[]{a,0});
        int[] dis = new int[N+1];
        int MAX = 9999999;
        Arrays.fill(dis,MAX);
        dis[a] = 0;     //출발지 설정

        while(!pq.isEmpty()){

            int[] nowL = pq.poll();
            int now = nowL[0];
            int dist = nowL[1];

            for(int i=0;i<LIST.get(now).size();i++){

                int[] nextL = LIST.get(now).get(i);
                int next=  nextL[0];
                int nextDis = nextL[1];

                if(dis[next]>dist+nextDis){
                    dis[next] = dist + nextDis;
                    pq.add(new int[]{next,dis[next]});
                }
            }
        }

        return dis;
    }
}