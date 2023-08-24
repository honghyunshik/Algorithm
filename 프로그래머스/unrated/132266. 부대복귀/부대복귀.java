import java.util.*;

class Solution {


    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        int[] answer = new int[sources.length];
        int[] sources_all = new int[n+1];
        ArrayList<ArrayList<Integer>> roads_new = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            roads_new.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            roads_new.get(roads[i][0]).add(roads[i][1]);
            roads_new.get(roads[i][1]).add(roads[i][0]);
        }
        Arrays.fill(sources_all,-1);
        boolean[] visited = new boolean[n+1];
        class Road{
            int l,r,dis;
            Road(int l,int r,int dis){
                if(l>r){
                    this.l = r;
                    this.r = l;
                }else{
                    this.l = l;
                    this.r = r;
                }
                this.dis = dis;
            }
        }

        Queue<Road> queue = new LinkedList<>();

        for(int i=0;i<roads_new.get(destination).size();i++){
            queue.add(new Road(roads_new.get(destination).get(i),destination,0));
        }

        visited[destination] = true;
        sources_all[destination] = 0;
        while(!queue.isEmpty()){
            Road now = queue.poll();

            int l = now.l;
            int r = now.r;
            if(visited[l]&&visited[r]) continue;
            int dis = now.dis;

            if(visited[l]){
                sources_all[r] = dis+1;
                visited[r] = true;
                for(int i=0;i<roads_new.get(r).size();i++){
                    int next = roads_new.get(r).get(i);
                    if(!visited[next]){
                        queue.add(new Road(r,next,dis+1));
                    }
                }
            }else{
                sources_all[l] = dis+1;
                visited[l] = true;
                for(int i=0;i<roads_new.get(l).size();i++){
                    int next = roads_new.get(l).get(i);
                    if(!visited[next]){
                        queue.add(new Road(l,next,dis+1));
                    }
                }
            }
            
        }
        for(int i=0;i<sources.length;i++){
            answer[i] = sources_all[sources[i]];
        }

        return answer;
    }
}