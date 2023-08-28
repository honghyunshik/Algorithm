import java.util.*;
class Solution {
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int cnt = 0;
        for(int i=0;i<lock.length;i++){
            for(int j=0;j<lock[i].length;j++){
                if(lock[i][j]==0) cnt++;
            }
        }
        for(int a=0;a<4;a++){
            
            key = round(key);
            
            for(int lStart=0;lStart<lock.length;lStart++){
                
                for(int rStart=0;rStart<lock[0].length;rStart++){
                    
                    for(int lEnd=lStart;lEnd<Math.min(lock.length,lStart+key.length);lEnd++){
                        
                        for(int rEnd=rStart;rEnd<Math.min(lock[0].length,rStart+key.length);rEnd++){
                            
                            if(fit(lStart,rStart,lEnd,rEnd,key,lock,cnt)) return true;
                            
                        }
                    }
                    
                }
            }
        }
        return false;
    }
    
    boolean fit(int lStart, int rStart, int lEnd, int rEnd, int[][] key, int[][] lock, int cnt){
        
        int keyL = 0, keyR = 0;
        if(lStart==0) keyL = key.length-1-(lEnd-lStart);
        if(rStart==0) keyR = key.length-1-(rEnd-rStart);
        int CNT = 0;
        for(int i=lStart;i<=lEnd;i++){
            
            int tempKeyR = keyR;
            for(int j=rStart;j<=rEnd;j++){
                
                if(key[keyL][tempKeyR]==lock[i][j]) return false;
                if(lock[i][j]==0) CNT++;
                tempKeyR++;
            }
            keyL++;
        }
        if(CNT==cnt) return true;
        return false;
    }
    
    int[][] round(int[][] key){
        
        int n = key.length, m = key[0].length;
        int[][] temp = new int[n][m];
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                temp[j][n-i-1] = key[i][j];
            }
        }
        return temp;
        
    }
}