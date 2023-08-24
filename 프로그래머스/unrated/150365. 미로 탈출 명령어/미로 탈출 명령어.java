import java.util.*;

class Solution {
    //abcdefghijklmnopqr
    //d l r u
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int dis = Math.abs(y-c) + Math.abs(r-x);
        if((k-dis)%2!=0||k<dis) return "impossible";
        StringBuilder sb = new StringBuilder();
        int mod = (k-dis)/2;
        
        //아래로 쭉
        for(;x<r;x++){
            sb.append('d');
        }
 
        //더 갈수 있냐?
        for(;x<Math.min(n,x+mod);x++){
            sb.append('d');
            mod--;
        }
        //왼쪽으로 쭉
        for(;y>c;y--){
            sb.append('l');
        }
        //더 갈수 있냐?
        for(;y>Math.max(1,y-mod);y--){
            sb.append('l');
            mod--;
        }
        
        //오른쪽 왼쪽 왔다갔다
        if(y<m){
            for(int i=0;i<mod;i++){
                sb.append("rl");
            }
            mod = 0;
        }
        //오른쪽 쭉
        for(;y<c;y++){
            sb.append('r');
        }
        //위아래 왔다갔다
        if(x>1){
            for(int i=0;i<mod;i++){
                sb.append("ud");
            }
        }
        for(;x>r;x--){
            sb.append('u');
        }
        return sb.toString();
    }
}
