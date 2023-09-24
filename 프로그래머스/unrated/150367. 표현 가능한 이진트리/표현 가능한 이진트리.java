import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        
        int[] answer = new int[numbers.length];
        
         for(int idx=0;idx<numbers.length;idx++){
            
            char[] arr = toBinary(numbers[idx]).toCharArray();
            
            char result = dfs(arr.length/2,getDepth(arr.length/2),arr);
            if(result=='x') answer[idx] = 0;
            else answer[idx] = 1;
            
        }
        
        return answer;
    }
    
    //높이 구하기
    int getDepth(int num){
        
        int dep = 1;
        while(num>1){
            dep++;
            num/=2;
        }
        return dep;
    }
    
    //표현할 수 없는 경우 -> 자식 노드는 1인데 부모 노드가 0인 경우
    char dfs(int idx, int depth, char[] arr){
        
        //idx가 홀수이다 -> 리프노드이다
        if(idx%2!=0||depth==1){
            return arr[idx];
        }
        int leftChildIdx = idx - (int)Math.pow(2,depth-2);
        int rightChildIdx = idx + (int)Math.pow(2,depth-2);
      
        char leftVal = dfs(leftChildIdx,depth-1,arr);
        char rightVal = dfs(rightChildIdx,depth-1,arr);
        
        //자식노드에서 X면 부모노드도 X
        if(leftVal=='x'||rightVal=='x') return 'x';
        //자식노드가 1인데 부모노드가 0이면 X
        if(arr[idx]=='0'&&(leftVal=='1'||rightVal=='1')) return 'x';
        
        return arr[idx];
    }
    
    int getLen(long num){
        
        //길이 1 : 1 ~ 2^1 - 1
        //길이 3 : 2^1 ~ 2^3-1
        //길이 7 : 2^3 ~ 2^7-1
        if(num==1) return 1;
        
        int k = 0;
        
        while(num>Math.pow(2,Math.pow(2,k)-1)-1){
            k++;
        }
        
        return (int)Math.pow(2,k)-1;
     }
    
    //앞에 더미노드를 추가한 문자열 생성
    //앞에 0하나 더붙여서 1부터 Index 시작
    String toBinary(long num){
        
        StringBuilder sb = new StringBuilder();
        int len = getLen(num);
        while(num>0){
            sb.insert(0,num%2);
            num/=2;
        }
        
        int cnt = len-sb.length();
        
        for(int i=0;i<=cnt;i++){
            sb.insert(0,"0");
        }
        return sb.toString();
        
    }
}