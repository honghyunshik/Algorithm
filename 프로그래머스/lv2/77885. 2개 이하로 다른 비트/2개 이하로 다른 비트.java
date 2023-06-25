class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            
            if(numbers[i]%2==0){
                answer[i] = numbers[i]+1;
                continue;
            }
            String bit = toBit(numbers[i]);
            bit = upBit(bit);
            answer[i] = toLong(bit);
        }
        return answer;
    }
    
    private long toLong(String str){
        
        long ans = 0;
        long k = 1;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='1'){
                ans += k;
            }
            k*=2;
        }
        return ans;
    }
    
    private String upBit(String str){
        
        int zero = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='0'){
                zero = i;
                break;
            }
        }
        if(zero==-1){
            sb.append("10");
            for(int i=0;i<str.length()-1;i++){
                sb.append("1");
            }
        }else{
            sb.append(str.substring(0,zero));
            if(zero==str.length()-1) sb.append("1");
            else sb.append("10");
            for(int i=sb.length();i<str.length();i++){
                sb.append("1");
            }
        }
        return sb.toString();
    }
    
    private String toBit(long num){
        
        StringBuilder sb = new StringBuilder();
        
        while(num>0){
            sb.insert(0,num%2);
            num/=2;
        }
        return sb.toString();
    }
    
    
}