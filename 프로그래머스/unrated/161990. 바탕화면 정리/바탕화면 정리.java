import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int minL = n;
        int minR = m;
        int maxL = -1;
        int maxR = -1;
        
        for(int i = 0; i<n;i++){
            
            for(int j = 0; j<m;j++){
                
                if(wallpaper[i].charAt(j)=='#'){
                    
                    minL = Math.min(minL,i);
                    minR = Math.min(minR,j);
                    maxL = Math.max(maxL,i+1);
                    maxR = Math.max(maxR,j+1);
                }
            }
        }
        
        
        return new int[]{minL,minR,maxL,maxR};
    }
}