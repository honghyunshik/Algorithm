class Solution {
    public int solution(int n) {
        int answer = 0;
        int ncnt = cnt1(n);
        while(n<1000000){
            n++;
            if(ncnt==cnt1(n)) return n;
        }
        return answer;
    }
    
    private int cnt1(int n){
        
        int cnt = 0;
        while(n>0){
            if(n%2==1) cnt++;
            n/=2;
        }
        
        
        return cnt;
    }
    
}