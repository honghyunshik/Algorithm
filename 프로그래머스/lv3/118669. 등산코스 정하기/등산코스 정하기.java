import java.util.*;

class Solution {
    
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        int[] mount = new int[n+1];
        ArrayList<ArrayList<int[]>> EDGE = new ArrayList<>();
        Arrays.sort(summits);
        for(int i=0;i<=n;i++){
            EDGE.add(new ArrayList<>());
        }
        
        for(int[] path:paths){
            EDGE.get(path[0]).add(new int[]{path[1],path[2]});
            EDGE.get(path[1]).add(new int[]{path[0],path[2]});
        }
        
        //출입구는 1, 산봉우리들은 2
        
        for(int num:gates){
            mount[num] = 1;
        }
        for(int num:summits){
            mount[num] = 2;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        
        int[] dis = new int[n+1];
        int summit = 0;
        int intensity = Integer.MAX_VALUE;
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int gate:gates){
            pq.add(new Node(gate,0));
            dis[gate] = 0;
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nowIdx = node.idx;
            int nowDis = node.dis;
            if(nowDis>dis[nowIdx]) continue;
            if(mount[nowIdx]==2) continue;
            ArrayList<int[]> edge = EDGE.get(nowIdx);
            for(int[] ed:edge){
                int next = ed[0];
                int nextDis = ed[1];
                if(mount[next]==1) continue;
                if(dis[next]>Math.max(nextDis,nowDis)){
                    dis[next] = Math.max(nextDis,nowDis);
                    pq.add(new Node(next,dis[next]));
                }
            }
        }
        for(int sum:summits){

            if(dis[sum]<intensity){
                intensity = dis[sum];
                summit = sum;
            }
        }
        return new int[]{summit,intensity};
    }
 
}
class Node{
    int idx,dis;
    Node(int idx, int dis){
        this.idx = idx;
        this.dis = dis;
    }
}