class Solution {
    public int solution(int n) {
        int answer = 1;
        int size = n%2==0?n/2+1:n/2+2;
        int l = 1, r = 1;
        int sum = 0;
        if(n==1) return 1;
        while(l<=r&&r<=size){
            if(sum<n){     
                sum+=r++;
            }else if(sum>n){

                sum-=l++;
             
            }else{
                answer++;
                sum+=r++-l++;
            }
            
        }
        return answer;
    }
}