import java.util.*;
class Solution {
    
    static Node[][] parent;
    static String[][] val;
    
    public String[] solution(String[] commands) {
        
        parent = new Node[51][51];
        val = new String[51][51];
        ArrayList<String> ans = new ArrayList<>();
        
        for(String command:commands){
            
            if(command.startsWith("UPDATE")){
                
                String[] li = command.split(" ");
                if(li.length==4){
                    
                    int x = Integer.parseInt(li[1]);
                    int y = Integer.parseInt(li[2]);
                    
                    Node par = find(x,y);
                    val[par.x][par.y] = li[3];
                    
                }else{
                    for(int i=1;i<=50;i++){
                        for(int j=1;j<=50;j++){
                            
                            if(val[i][j]!=null&&val[i][j].equals(li[1])){
                                val[i][j] = li[2];
                            }
                            
                        }
                    }
                }
            }else if(command.startsWith("MERGE")){
                
                String[] li = command.split(" ");
                int r1 = Integer.parseInt(li[1]);
                int c1 = Integer.parseInt(li[2]);
                int r2 = Integer.parseInt(li[3]);
                int c2 = Integer.parseInt(li[4]);
                union(r1,c1,r2,c2);
               
            }else if(command.startsWith("UNMERGE")){
                
              
                
                String[] li = command.split(" ");
                int r = Integer.parseInt(li[1]);
                int c = Integer.parseInt(li[2]);
                Node par = find(r,c);
                String tem = val[par.x][par.y];
                
                ArrayList<int[]> temp = new ArrayList<>();
                for(int i=1;i<=50;i++){
                    for(int j=1;j<=50;j++){      
                        Node now = find(i,j);
                        if(i==r&&j==c) continue;
                        if(now.x==par.x&&now.y==par.y){
                            temp.add(new int[]{i,j});
                        }
                        
                    }
                }
                for(int[] arr:temp){
                    int i = arr[0];
                    int j = arr[1];
                    parent[i][j].x = i;
                    parent[i][j].y = j;
                    val[i][j] = null;
                }
                parent[r][c].x = r;
                parent[r][c].y = c;
                val[r][c] = tem;
                
                
            }else{
                String[] li = command.split(" ");
                int r = Integer.parseInt(li[1]);
                int c = Integer.parseInt(li[2]);
                Node now = find(r,c);
                
                if(val[now.x][now.y]==null) ans.add("EMPTY");
                else ans.add(val[now.x][now.y]);
            }
        }
        String[] answer = new String[ans.size()];
        
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    private void union(int r1, int c1, int r2, int c2){
        
        if(r1==r2&&c1==c2) return;
        Node p1 = find(r1,c1);
        Node p2 = find(r2,c2);
        if(p1.x==p2.x&&p2.y==p1.y) return;
        if(val[p1.x][p1.y]==null) val[p1.x][p1.y] = val[p2.x][p2.y];
        val[p2.x][p2.y] = null;
        parent[p2.x][p2.y] = new Node(p1.x,p1.y);
        
    }
    
    //부모노드 반환
    private Node find(int x, int y){
        
        Node now = parent[x][y];
        if(now==null){
            now = new Node(x,y);
            parent[x][y] = now;
            return now;
        }
        int pX = now.x;
        int pY = now.y;
        if(x==pX&&y==pY) return now;
        return find(pX,pY);
        
    }
}

class Node{
    int x,y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
} 