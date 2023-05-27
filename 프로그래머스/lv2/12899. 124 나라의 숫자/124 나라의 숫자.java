
class Solution {
    
    
    //1 2 4 11 12 14 21 22 24 41 42 44 111 112 114 121 122 124
    public String solution(int n) {
        
        String answer = "";
        String[] arr = {"4","1","2"};
        while(n>0){
            
            answer = arr[n%3] + answer;
            n = (n-1)/3;
        }
        
        return answer;
    }
}