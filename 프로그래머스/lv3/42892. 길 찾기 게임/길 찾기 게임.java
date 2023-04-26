import java.util.*;

class Solution {
    
    static int[][] answer; 
    static int idx1 = 0;
    static int idx2 = 0;
    public int[][] solution(int[][] nodeinfo) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<nodeinfo.length;i++){
            map.put(nodeinfo[i][0]+"+"+nodeinfo[i][1],i+1);
        }
        
        Arrays.sort(nodeinfo,(a,b)->b[1]-a[1]);
        answer =  new int[2][nodeinfo.length];
        Node root = null;
        for(int i=0;i<nodeinfo.length;i++){
            int num = map.get(nodeinfo[i][0]+"+"+nodeinfo[i][1]);
            root = insertNode(root,num,nodeinfo[i][0]);
        }
        preOrder(root);
       
       postOrder(root);
        
        return answer;
    }
    
    private void preOrder(Node node){
        
        answer[0][idx1++] = node.num;
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
        
    }
    
    private void postOrder(Node node){
        
        if(node.left!=null) postOrder(node.left);
        if(node.right!=null) postOrder(node.right);
        answer[1][idx2++] = node.num;
    }
    
    
    private Node insertNode(Node node, int num, int x){
        
        if(node==null) return new Node(num,x);
        
        //작은값이 들어오면 leftChild로
        if(node.x>x) node.left = insertNode(node.left,num,x);
        else node.right = insertNode(node.right,num,x);
        
        return node;
    }
    
    class Node{
        
        int num, x;
        Node left, right;
        Node(int num, int x){
            this.num = num;
            this.x = x;
        }
    }
}