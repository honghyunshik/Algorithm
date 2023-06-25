class Solution {
    int answer = 0;
    public int solution(int n) {
        dfs(0,0,n);
        return answer;
    }
    private void dfs(int l, int r, int n){
        
        if(l==n){
            answer++;
            return;
        }
        
        if(l>r){
            dfs(l,r+1,n);
            dfs(l+1,r,n);
        }else dfs(l+1,r,n);
    }
}