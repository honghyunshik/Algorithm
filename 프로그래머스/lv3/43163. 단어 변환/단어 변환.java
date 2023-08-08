import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin,0));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            String data = now.data;
            int dis = now.dis;
            if(data.equals(target)) return dis;
            for(int i=0;i<words.length;i++){
                if(visited[i]) continue;
                int temp = 0;
                for(int j =0;j<words[i].length();j++){
                    if(data.charAt(j)!=words[i].charAt(j)) temp++;
                }
                if(temp==1){
                    visited[i] = true;
                    queue.add(new Node(words[i],dis+1));
                }
            }
        }
        return 0;
    }
}

class Node{
    String data;
    int dis;
    Node(String data, int dis){
        this.data = data;
        this.dis = dis;
    }
}