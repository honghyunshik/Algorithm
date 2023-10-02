class Solution {
    public int solution(int n, int k) {
        
        int answer = 0;
        String kNum = toK(n,k);
        for(int i=0;i<kNum.length();i++){
            
            long temp = 0;
            if(kNum.charAt(i)-48==0) continue;
            for(int j=i;j<kNum.length();j++){
                if(kNum.charAt(j)-48==0) break;
                temp*=10;
                temp+=kNum.charAt(j)-48;
                if(isSosu(temp)){
                    if(isPattern(i,j,kNum)) {
                       
                        answer++;
                    }
                    
                }
                
            }
        }
        
        return answer;
    }
    
    //조건에 맞는지 판단하는 함수
    boolean isPattern(int i,int j, String kNum){
        
        //조건 1
        if(i>0&&j<kNum.length()-1&&kNum.charAt(i-1)-48==0&&kNum.charAt(j+1)-48==0) return true;
        //조건 2
        if(i==0&&j<kNum.length()-1&&kNum.charAt(j+1)-48==0) return true;
        //조건 3
        if(i>0&&j==kNum.length()-1&&kNum.charAt(i-1)-48==0) return true;
        //조건 4
        if(i==0&&j==kNum.length()-1) return true;
        return false;
    }
    
    //k 진법으로 변환하는 함수
    String toK(int n, int k){
        
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.insert(0,n%k);
            n/=k;
        }
        return sb.toString();
    }
    
    //소수인지 판별하는 함수
    boolean isSosu(long n){
        
        if(n<2) return false;
        for(int i=2;(long)i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}