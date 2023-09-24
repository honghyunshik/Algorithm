import java.util.*;

class Solution {
    
    String[][] board = new String[51][51];
    Node[][] parent = new Node[51][51]; 
    
    public String[] solution(String[] commands) {
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String command:commands){
            
            if(command.startsWith("UPDATE")){
                
                String[] temp = command.split(" ");
                
                if(temp.length==4){
                    
                    int r = Integer.parseInt(temp[1]);
                    int c = Integer.parseInt(temp[2]);
                    String value = temp[3];
                    update(r,c,value);
                }else{
                    
                    String value1 = temp[1];
                    String value2 = temp[2];
                    update(value1,value2);
                }
                
            }else if(command.startsWith("MERGE")){
                
                String[] temp = command.split(" ");
                int r1 = Integer.parseInt(temp[1]);
                int c1 = Integer.parseInt(temp[2]);
                int r2 = Integer.parseInt(temp[3]);
                int c2 = Integer.parseInt(temp[4]);
                merge(r1,c1,r2,c2);
            }else if(command.startsWith("UNMERGE")){
                
                String[] temp = command.split(" ");
                int r = Integer.parseInt(temp[1]);
                int c = Integer.parseInt(temp[2]);
        
                unmerge(r,c);
            }else{
                
                String[] temp = command.split(" ");
                int r = Integer.parseInt(temp[1]);
                int c = Integer.parseInt(temp[2]);
                Node node = find(r,c);
                if(node==null){
                    list.add(board[r][c]);
                }else{
                    list.add(board[node.r][node.c]);
                }
                
            }
            
        }
        
        
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            if(list.get(i)==null){
                answer[i] = "EMPTY";
            }else answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void update(int r, int c, String value){
        
        Node node = find(r,c);
        board[node.r][node.c] = value;
    }
    
    public void update(String value1, String value2){
        
        for(int i=1;i<=50;i++){
            
            for(int j=1;j<=50;j++){
                
                if(board[i][j]!=null&&board[i][j].equals(value1)){
                    board[i][j] = value2;
                }
            }
        }
    }
    
    public void merge(int r1, int c1, int r2, int c2){
        
        if(r1==r2&&c1==c2) return;
        
        Node parentNode1 = find(r1,c1);
        Node parentNode2 = find(r2,c2);
        
        //r1, c1 셀이 비어있을 경우 r2, c2 cell 값 갖는다
        if(board[parentNode1.r][parentNode1.c]==null){
            parent[parentNode1.r][parentNode1.c] = parentNode2;
        }else{
            parent[parentNode2.r][parentNode2.c] = parentNode1;
        }
    } 
    //부모 찾기
    public Node find(int r, int c){
        
        Node now = parent[r][c];
        
        if(now==null){
            Node node = new Node(r,c);
            parent[r][c] = node;
            return node;
        }
        
        if(now.r==r&&now.c==c) return now;
        
        now = find(now.r,now.c);
        parent[r][c] = now;
        return now;
    }
    
    public void unmerge(int r, int c){
        
        Node node = find(r,c);
        if(node==null) return;
        String value = board[node.r][node.c];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=1;i<=50;i++){
            
            for(int j=1;j<=50;j++){
                
                if(i==r&&j==c) continue;
                Node temp = find(i,j);
                if(temp!=null&&temp.r==node.r&&temp.c==node.c){
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<list.size();i++){
            int[] now = list.get(i);
            parent[now[0]][now[1]] = null;
            board[now[0]][now[1]] = null;
        }
        parent[r][c] = new Node(r,c);
        board[r][c] = value;
    }
}

class Node{
    int r, c;
    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}