import java.util.*;
class Solution {
    //n : 노드 수  s : 출발 지점   a : A 도착지점   b : B 도착지점
    
    static ArrayList<ArrayList<int[]>> map;
    static int N;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        N = n;
        //map에 대한 설정
        map = new ArrayList<>(); 
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<fares.length;i++){
            int l = fares[i][0];
            int r = fares[i][1];
            int pay = fares[i][2];
            map.get(l).add(new int[]{r,pay});
            map.get(r).add(new int[]{l,pay});
        }
        
        int[] startS = dijkstra(s);
        int[] backA = dijkstra(a);
        int[] backB = dijkstra(b);
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            answer = Math.min(answer,startS[i]+backA[i]+backB[i]);
        }
        
        return answer;
        
    }
    private int[] dijkstra(int s){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{s,0});
        int[] dis = new int[N+1];
        int MAX = 9999999;
        Arrays.fill(dis,MAX);
        dis[s] = 0;     //출발지 설정
        
        while(!pq.isEmpty()){
            
            int[] nowL = pq.poll();
            int now = nowL[0];
            int dist = nowL[1];
            
            for(int i=0;i<map.get(now).size();i++){
                
                int[] nextL = map.get(now).get(i);
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