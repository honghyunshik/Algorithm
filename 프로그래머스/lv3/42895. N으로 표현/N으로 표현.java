import java.util.*;
    
class Solution {
    public int solution(int N, int number) {
        
        int answer = 0;
        
        int num = N;
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=8;i++){
            list.add(new HashSet<>());
        }
        
        for(int i=1;i<=5;i++){
            list.get(i).add(num);
            num = num*10 + N;
        }
        
        for(int i=2;i<=8;i++){
            
            for(int j=1;j<i;j++){
                
                HashSet<Integer> first = list.get(j);
                HashSet<Integer> second = list.get(i-j);
                
                for(int fi:first){
                    
                    for(int se:second){
                        
                        
                        list.get(i).add(fi+se);
                        list.get(i).add(fi*se);
                        if(fi>se) list.get(i).add(fi-se);
                        if(fi>=se) list.get(i).add(fi/se);
                    }
                }
            }
        }
        for(int i=1;i<=8;i++){
            if(list.get(i).contains(number)) return i;
        }
        
       
        return -1;
    }   
    
    private boolean valid(int n){
        
        if(n>0&&n<100000) return true;
        return false;
    }
}