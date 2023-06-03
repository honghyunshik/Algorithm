class Solution {
    
    //가로 길이가 x, 세로 길이가 y라고 할 때
    //x+y = brwon + yellow
    //
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        
        for(int i=1;i*i<=yellow;i++){
            
            if(yellow%i==0){
                
                int yellowLeft = yellow/i;
                int yellowRight = i;
                for(int j=1;j*j<=sum;j++){
                    
                    int brownLeft = sum/j;
                    int brownRight = j;
                   
                    if(brownLeft-yellowLeft<2||brownRight-yellowRight<2) continue;
                    if((brownLeft-yellowLeft)*yellowRight +(brownRight-yellowRight)*yellowLeft==brown-4){
                        return new int[]{brownLeft,brownRight};
                    }
                }
                
            }
            
            
        }
        return answer;
    }
    
    
}