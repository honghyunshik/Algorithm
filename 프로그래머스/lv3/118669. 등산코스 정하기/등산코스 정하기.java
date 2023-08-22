import java.util.*;
class Solution {
    
    //gates는 출입구    summits는 산봉우리
    //산봉우리 낮은걸로
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<paths.length;i++){
            int l = paths[i][0];
            int r = paths[i][1];
            int dis = paths[i][2];
            list.get(l).add(new int[]{r,dis});
            list.get(r).add(new int[]{l,dis});
        }
        HashMap<Integer,Integer> gates_map = new HashMap<>();
        HashMap<Integer,Integer> summits_map = new HashMap<>();
        for(int gate:gates){
            gates_map.put(gate,1);
        }
        for(int summit:summits){
            summits_map.put(summit,1);
        }
        int min_intensity = Integer.MAX_VALUE;
        int san = min_intensity;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.intensity-b.intensity);
        for(int gate:gates){
            boolean[] visited = new boolean[n+1];
            for(int i=0;i<list.get(gate).size();i++){
                int[] arr = list.get(gate).get(i);
                pq.add(new Node(arr[0],arr[1]));
            }
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(now.intensity>min_intensity) continue;   //최소가 아니면 pass
                if(summits_map.get(now.num)!=null){     //산봉우리에 도착했으면 비교
                    if((min_intensity==now.intensity&&san>now.num)||min_intensity>now.intensity){
                        san = now.num;
                        min_intensity = now.intensity; 
                    }
                    continue;
                }
                for(int i=0;i<list.get(now.num).size();i++){
                    int[] arr = list.get(now.num).get(i);
                    if(arr[1]>min_intensity) continue;
                    if(gates_map.get(arr[0])!=null) continue;  //출발지는 pass
                    if(visited[arr[0]]) continue;      //이미 방문한 node면 pass
                    visited[now.num] = true;
                    pq.add(new Node(arr[0],Math.max(arr[1],now.intensity)));         
                }
            }   
        }
        return new int[]{san,min_intensity};
    }
}

class Node{
    int num; 
    int intensity;      //최대 이동시간
    
    Node(int num, int intensity){
        this.num = num;
        this.intensity = intensity;
    }
           
}