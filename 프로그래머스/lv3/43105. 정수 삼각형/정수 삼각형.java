import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] ans = new int[triangle.length][];
        for(int i=0;i<triangle.length;i++){
            ans[i] = new int[triangle[i].length];
        }
        ans[0][0] = triangle[0][0];
        
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    ans[i][j] = triangle[i][j] + ans[i-1][0];
                }else if(j==triangle[i].length-1){
                    ans[i][j] = triangle[i][j] + ans[i-1][j-1];
                }else{
                    ans[i][j] = Math.max(ans[i-1][j-1],ans[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            answer  = Math.max(answer,ans[triangle.length-1][i]);
        }
        return answer;
    }
}