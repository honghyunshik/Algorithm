class Solution {
    public int solution(int[] arr) {
        int answer = 0;
         int back = arr[0];
        for(int i=1;i<arr.length;i++){
            
            back = getLCM(back,arr[i]);
            
        }
         return back;
    }
    
    private int getGCD(int a, int b){
        
        if(a%b==0) return b;
        return getGCD(b,a%b);
    }
    
    private int getLCM(int a, int b){
        
        return a*b/getGCD(a,b);
    }
}