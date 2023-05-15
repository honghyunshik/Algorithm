import java.util.*;
class Solution {
    
    static int[][] dist;
    
    public int solution(int n, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] ed:edge){
            int a = ed[0];
            int b = ed[1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int[] dist = new int[n+1];
        int MAX = 9999999;
        Arrays.fill(dist,MAX);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dist[0] = 0;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int num = now.num;
            int dis = now.dis;
            dist[num] = dis;
            for(int i=0;i<list.get(num).size();i++){
                int next = list.get(num).get(i);
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(new Node(next,dis+1));
            }
            
        }
        Arrays.sort(dist);
        int now = dist[n];
        int answer = 1;
        for(int i=n-1;i>=1;i--){
            if(now==dist[i]) answer++;
            else break;
        }
        return answer;
    }
}
class Node{
    int num, dis;
    Node(int num, int dis){
        this.num = num;
        this.dis = dis;
    }
}