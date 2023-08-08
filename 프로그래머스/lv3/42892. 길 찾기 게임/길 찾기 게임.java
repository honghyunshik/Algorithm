import java.util.*;

class Solution {
    
    int idx = 0;
    int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        
        answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            nodeinfo[i] = new int[]{nodeinfo[i][0],nodeinfo[i][1],i+1};
        }
        Arrays.sort(nodeinfo,(a,b)->b[1]-a[1]);
        Node root = new Node(nodeinfo[0]);
        for(int i=1;i<nodeinfo.length;i++){
            makeBinaryTree(root, nodeinfo[i]);
        }
        preOrder(root);
        idx = 0;
        postOrder(root);
        return answer;
    }
    private void preOrder(Node node){
        
      
        answer[0][idx++] = node.val;
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }
    
    private void postOrder(Node node){
        
        
        if(node.left!=null) postOrder(node.left);
        if(node.right!=null) postOrder(node.right);
       
        answer[1][idx++] = node.val;
    }
    
    private Node makeBinaryTree(Node node, int[] arr){
        
        if(node==null) return new Node(arr);
        
        if(node.x>arr[0]) node.left = makeBinaryTree(node.left,arr);
        else node.right = makeBinaryTree(node.right,arr);
        
        return node;
    }
}

class Node{
    
    int x,y,val;
    Node left, right;
    Node(int[] arr){
        this.x = arr[0];
        this.y = arr[1];
        this.val = arr[2];
    }
}