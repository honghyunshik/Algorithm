import java.util.*;
class Solution {
    
    static int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    
    static int[][][] dp;
    static int len;
    static String NUMBER;
    
    public int solution(String numbers) {
        
        int answer = 0;
        len = numbers.length();
        dp = new int[len+1][10][10];
        NUMBER = numbers;
        
        for(int i=0;i<len+1;i++){
            for(int j=0;j<10;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        
        
        return recursive(0,4,6);
    }
    
    private int recursive(int idx, int l, int r){
        
        if(idx==len) return 0;
        
        if(dp[idx][l][r]!=-1) return dp[idx][l][r];
        
        int num = NUMBER.charAt(idx)-48;
        int min = Integer.MAX_VALUE;
        
        if(l!=num) min = Math.min(min,recursive(idx+1,l,num) + cost[r][num]);
        if(r!=num) min = Math.min(min,recursive(idx+1,num,r) + cost[l][num]);
        
        return dp[idx][l][r] = min;
    }
}