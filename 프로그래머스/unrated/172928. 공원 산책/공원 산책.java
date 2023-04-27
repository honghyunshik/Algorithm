class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int l = 0, r = 0;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j)=='S'){
                    l = i;
                    r = j;
                    break;
                }
            }
        }
        int n = park.length;
        int m = park[0].length();
        
        for(String route:routes){
            
            boolean isX = false;
            char dir = route.charAt(0);
            int dis = route.charAt(2)-48;
            int di = 0;
            if(dir=='N') di = 3;
            else if(dir=='S') di = 2;
            else if(dir=='W') di = 1;
            
            int nextL = l;
            int nextR = r;
            for(int i=1;i<=dis;i++){
                nextL += D[di][0];
                nextR += D[di][1];
                if(nextL<0||nextL>n-1||nextR<0||nextR>m-1){
                    isX = true;
                    break;
                }
                if(park[nextL].charAt(nextR)=='X'){
                    isX = true;
                    break;
                }
            }
            if(!isX){
                
            l = nextL;
            r = nextR;
              
            }
            
        }
        
        return new int[]{l,r};
    }
}