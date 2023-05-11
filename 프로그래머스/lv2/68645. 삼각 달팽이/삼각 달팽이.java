class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n+1][n+1];
        int size = n*(n+1)/2;
        int l = 1, r = 1;
        int dir = 1;
        for(int i=1;i<=size;i++){
            
            arr[l][r] = i;
            if(dir==1&&(l+1>n||(l+1<=n&&arr[l+1][r]!=0))) dir = 2;
            if(dir==2&&(r+1>n||(r+1<=n&&arr[l][r+1]!=0))) dir = 3;
            if(dir==3&&(arr[l-1][r-1]!=0)) dir = 1;
            if(dir==1) l++;
            if(dir==2) r++;
            if(dir==3){
                l--;
                r--;
            }
        }
        int[] answer = new int[size];
        int cnt = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                answer[cnt++] = arr[i][j];
            }
        }
        return answer;
    }
}