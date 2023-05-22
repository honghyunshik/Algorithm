import java.util.*;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        Node head = null;
        int size = 0;
        for(String city:cities){
            
            city = city.toLowerCase();
            Node k = head;
            
            /*
            while(k!=null){
                System.out.print(k.city + " --> ");
                k  = k.right;
            }
            System.out.println();
            System.out.println();
            
            System.out.println(set);
            */
            if(set.contains(city)){
                  
                Node node = head;
                if(!node.city.equals(city)){
                    while(node.right!=null&&!node.right.city.equals(city)){
                    node = node.right;
                }
                    Node next = node.right; 
                    node.right = node.right.right;
                    next.right = head;
                    head = next;
                    

                }
                answer++;
                
                
            }
            //현재 캐시에 city가 없으면 캐시 교체
            else{
                if(size<cacheSize){
                    
                    Node node = new Node(city);
                    node.right = head;
                    head = node;
                    size++;
                }else if(cacheSize>0){
                    
                    
                     Node node = new Node(city);
                    Node temp = head;
                    while(temp.right!=null&&temp.right.right!=null){
                        temp = temp.right;
                    }
                    if(temp.right==null){
                        set.remove(temp.city);
                        head = node;
                    }else{
                        set.remove(temp.right.city);
                        temp.right = null;
                        node.right = head;
                        head = node;
                    }
                    
                    
                }
                if(cacheSize!=0) set.add(city);
                answer+=5;
            }
            
            
        }
        return answer;
    }
}
class Node{
    String city;
    Node left,right;
    Node(String city){
        this.city = city;
    }
}