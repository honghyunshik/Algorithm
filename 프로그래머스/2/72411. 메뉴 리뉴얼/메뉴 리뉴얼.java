import java.util.*;

class Solution {
    
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
       if(a.len==b.len) return b.cnt-a.cnt;
        return a.len-b.len;
    });
    HashMap<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        for(String order:orders){
            for(int cour:course){
                if(order.length()<cour) break;
                inputBruteForce(order,0,new boolean[order.length()], 0, cour);
            }
        }
        
        map.forEach((key,value)->{
            
            pq.add(new Node(key,value,key.length()));
        });
        int nowCourse = course[0];
        int nowMax = 0;
        boolean isEnd = false;
        
        PriorityQueue<String> pqForStr = new PriorityQueue<>((a,b)->{
            return a.compareTo(b);
        });
        while(!pq.isEmpty()){
            Node node = pq.poll();
             if(isEnd){
                if(node.len==nowCourse) continue;
                
                if(node.cnt>=2){
                    nowCourse = node.len;
                    isEnd = false;
                    nowMax = node.cnt;
                    pqForStr.add(node.order);
                }
            }
            else if(nowMax>node.cnt) isEnd = true;
            else if(node.cnt>=2){
                nowMax = node.cnt;
                pqForStr.add(node.order);
            }
        }
        String[] answer = new String[pqForStr.size()];
        int idx = 0;
        while(!pqForStr.isEmpty()){
            answer[idx++] = pqForStr.poll();
        }        
        
                                                     
        return answer;
    }
    
    private void inputBruteForce(String word, int cnt, boolean[] arr, int idx, int target){
        
        if(cnt==target){
            PriorityQueue<Character> tempPQ = new PriorityQueue<>((a,b)->a-b);
           StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++){
                if(arr[i]) tempPQ.add(word.charAt(i));
            }
            while(!tempPQ.isEmpty()){
                sb.append(tempPQ.poll());
            }
            String temp = sb.toString();
            map.put(temp,map.getOrDefault(temp,0)+1);
            return;
        }
        
        if(idx==word.length()) return;
        
        arr[idx] = true;
        inputBruteForce(word,cnt+1,arr,idx+1,target);
        arr[idx] = false;
        inputBruteForce(word,cnt,arr,idx+1,target);
    }
}

class Node{
    
    String order;
    int cnt, len;
    
    public Node(String order, int cnt, int len){
        this.order = order;
        this.cnt = cnt;
        this.len = len;
    }
}