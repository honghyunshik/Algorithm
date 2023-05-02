import java.util.*;
class Solution {
    
    static int[][][] BOARD;
    static int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        
        BOARD = new int[n+1][n+1][2];
        N = n;
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int[] build:build_frame){
            
            int x = build[0];
            int y = build[1];
            //삭제
            if(build[3]==0){
                boolean can = true;
                //기둥 삭제
                if(build[2]==0){
                    BOARD[y][x][0] = 0;
                    //기둥을 받치고 있는 경우
                    if(y<n&&BOARD[y+1][x][0]==1){
                        if(!canGi(x,y+1)) can = false;
                    }
                    //보를 받치고 있는 경우
                    if(y<n&&BOARD[y+1][x][1]==1){
                        if(!canBo(x,y+1)) can = false;
                    }
                    if(x>0&&y<n&&BOARD[y+1][x-1][1]==1){
                        if(!canBo(x-1,y+1)) can = false;
                    }
                    
                }
                //보 삭제
                else{
                    BOARD[y][x][1] = 0;
                    //기둥을 받치고 있는 경우
                    if(BOARD[y][x][0]==1){
                        if(!canGi(x,y)) can = false;
                    }
                    if(x<n&&BOARD[y][x+1][0]==1){
                        if(!canGi(x+1,y)) can = false;
                    }
                    //보끼리 연결되어 있는 경우
                    if(x>0&&BOARD[y][x-1][1]==1){
                        if(!canBo(x-1,y)) can = false;
                    }
                    if(x<n&&BOARD[y][x+1][1]==1){
                        if(!canBo(x+1,y)) can = false;
                    }
                    
                }
                if(can){
                        int idx = -1;
                        for(int i=0;i<list.size();i++){
                            int[] now = list.get(i);
                            if(x==now[0]&&y==now[1]&&now[2]==build[2]){
                                idx = i;
                                break;
                            } 
                        }
                        if(idx!=-1) list.remove(idx);
                    }else{
                        BOARD[y][x][build[2]] = 1;
                }
            }
            //설치
            else{
                //기둥 설치
                if(build[2]==0){
                    if(canGi(x,y)){
                        BOARD[y][x][0] = 1;
                        list.add(new int[]{x,y,0});
                    }
                }
                //보 설치
                else{
                    if(canBo(x,y)){
                        BOARD[y][x][1]=1;
                        list.add(new int[]{x,y,1});
                    }
                }
            }
        }
        
        int[][] answer = new int[list.size()][3];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer,(a,b)->{
           if(a[0]==b[0]&&a[1]==b[1]) return a[2]-b[2];
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        return answer;
    }
    
    //기둥을 설치할 수 있는 경우는 바닥 위에 있거나
    //보의 한쪽 끝 부분 위에 있거나
    //다른 기둥 위에 있어야 한다
    private boolean canGi(int x, int y){
        
        if(y==0||BOARD[y][x][1]==1||(x>0&&BOARD[y][x-1][1]==1)||
           (y>0&&BOARD[y-1][x][0]==1)) return true;
        return false;
    }
    
    //보를 설치할 수 있는 경우는 한쪽 끝 부분이 기둥 위에 있거나
    //양쪽 끝부분이 다른 보와 동시에 연결되어 있어야 한다
    private boolean canBo(int x, int y){
        
        if((y>0&&BOARD[y-1][x][0]==1)||(y>0&&x<N&&BOARD[y-1][x+1][0]==1)) return true;
        if((x>0&&BOARD[y][x-1][1]==1)&&(x<N&&BOARD[y][x+1][1]==1)) return true;
        return false;
    }
}