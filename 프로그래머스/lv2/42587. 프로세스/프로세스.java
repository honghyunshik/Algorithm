class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int size = priorities.length;
        int cnt = 1;
        int idx = 0;
        boolean[] visited = new boolean[size];
        
        for(int i=1;i<=size;i++){
            
            int start = idx;
            int max = 0;
            int maxIdx = 0;
            
            for(int j=0;j<size;j++){
                if(!visited[start]&&max<priorities[start]){
                    max = priorities[start];
                    maxIdx = start;
                }
                start = start==size-1?0:start+1;
            }
            
            if(maxIdx==location){
                return cnt;
            }else{
                idx = maxIdx==size-1?0:maxIdx+1;
                visited[maxIdx] = true;
                cnt++;
            }
        }
       
        return answer;
    }
}