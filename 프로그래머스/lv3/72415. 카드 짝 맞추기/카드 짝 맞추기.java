import java.util.*;

class Solution {

    private static int answer;
    private static boolean[] check;
    private static HashMap<Integer, ArrayList<Point>> points;
    private static ArrayList<Integer> numbers;
    private static int dy[]={0,0,-1,1};
    private static int dx[]={-1,1,0,0};

    static class Point{
        int y,x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class Pair{
        int cnt,y,x;

        public Pair(int cnt, int y, int x) {
            this.cnt = cnt;
            this.y = y;
            this.x = x;
        }
    }

    private static int calculateCnt(int[][] board, int r,int c, int nr,int nc){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,r,c));
        int y,x;
        while (!q.isEmpty()){
            Pair p = q.poll();
            if(p.y== nr && p.x == nc){
                return p.cnt;
            }

            for(int i=0;i<4;i++){
                int newY = p.y+ dy[i];
                int newX = p.x+ dx[i];

                if(0<=newX && newX<4 && 0<=newY && newY<4){
                    q.offer(new Pair(p.cnt+1,newY,newX));
                }
            }
            y = p.y-1; x = p.x;
            while(y>=0){
                if(board[y][x]!=0){
                    q.offer(new Pair(p.cnt+1, y,x));
                    break;
                }
                if(y==0){
                    q.offer(new Pair(p.cnt+1, y,x));
                }
                y--;
            }
            y = p.y+1; x = p.x;
            while(y<4){
                if(board[y][x]!=0){
                    q.offer(new Pair(p.cnt+1, y,x));
                    break;
                }
                if(y==3){
                    q.offer(new Pair(p.cnt+1, y,x));
                }
                y++;
            }
            y = p.y; x = p.x-1;
            while(x>=0){
                if(board[y][x]!=0){
                    q.offer(new Pair(p.cnt+1, y,x));
                    break;
                }
                if(x==0){
                    q.offer(new Pair(p.cnt+1, y,x));
                }
                x--;
            }
            y = p.y; x = p.x+1;
            while(x<4){
                if(board[y][x]!=0){
                    q.offer(new Pair(p.cnt+1, y,x));
                    break;
                }
                if(x==3){
                    q.offer(new Pair(p.cnt+1, y,x));
                }
                x++;
            }
        }
        return 0;
    }

    private static void dfs(int[][] board, int cnt, int depth, int r, int c){

        if(depth >= numbers.size()){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i=0;i<numbers.size();i++){
            if(!check[numbers.get(i)]){
                check[numbers.get(i)] = true;
                ArrayList<Point> list = points.get(numbers.get(i));
                Point p1 = list.get(0);
                Point p2 = list.get(1);
                int first = calculateCnt(board, r,c,p1.y,p1.x);
                int second = calculateCnt(board, p1.y, p1.x, p2.y, p2.x);
                board[p1.y][p1.x] = 0;
                board[p2.y][p2.x] = 0;

                dfs(board, cnt+2+first+second, depth+1, p2.y,p2.x);

                board[p1.y][p1.x] = numbers.get(i);
                board[p2.y][p2.x] = numbers.get(i);

                first = calculateCnt(board, r,c,p2.y,p2.x);
                second = calculateCnt(board, p2.y, p2.x, p1.y, p1.x);
                board[p1.y][p1.x] = 0;
                board[p2.y][p2.x] = 0;

                dfs(board, cnt+2+first +second, depth+1, p1.y,p1.x);
                check[numbers.get(i)] = false;
                board[p1.y][p1.x] = numbers.get(i);
                board[p2.y][p2.x] = numbers.get(i);
            }
        }
    }


    static int solution(int[][] board, int r, int c) {
        answer = 987654321;
        check = new boolean[7];
        points = new HashMap<>();
        numbers=new ArrayList<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!=0){
                    if(points.get(board[i][j])==null){
                        ArrayList<Point> arrayList= new ArrayList<>();
                        arrayList.add(new Point(i,j));
                        points.put(board[i][j],arrayList);
                        numbers.add(board[i][j]);
                    } else {
                        points.get(board[i][j]).add(new Point(i,j));
                    }
                }
            }
        }

        dfs(board,0,0,r,c);
        return answer;
    }
   
}