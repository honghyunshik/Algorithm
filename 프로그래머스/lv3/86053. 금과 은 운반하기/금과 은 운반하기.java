class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long l = 0, r = (long)Math.pow(10,14)*4;
        while(l<r){
            
            long mid = (l+r)/2;
            
            if(!can(a,b,g,s,w,t,mid)){
                l = mid+1;
            }else r = mid;
        }
        return l;
    }
    boolean can(int a, int b, int[] g, int [] s, int[] w, int[] t, long time){
        
        long sumG = 0;
        long sumS = 0;
        long sumAll = 0;
        
        for(int i=0;i<g.length;i++){
               
            long cnt = time%(t[i]*2)>=t[i]?time/t[i]/2+1:time/t[i]/2;
            long tempG = Math.min(w[i] * cnt,g[i]);
            long tempS = Math.min(w[i] * cnt,s[i]);
            sumG += tempG;
            sumS += tempS;
            sumAll += Math.min(g[i]+s[i],w[i]*cnt);
            
        }
        if(a<=sumG&&b<=sumS&&sumAll>=a+b) return true;
        return false;
        
    }
}