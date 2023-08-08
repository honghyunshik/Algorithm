import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for(int i=0;i<=8;i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        list.get(2).add(11*N);
        list.get(3).add(111*N);
        list.get(4).add(1111*N);
        list.get(5).add(11111*N);
        
        for(int i=2;i<=8;i++){
            
            HashSet<Integer> set = list.get(i);
            for(int j=1;j<=i;j++){
                
                HashSet<Integer> first = list.get(j);
                HashSet<Integer> second = list.get(i-j);
                for(int fi:first){
                    for(int se:second){
                        set.add(fi+se);
                        set.add(fi-se);
                        set.add(fi*se);
                        if(fi!=0&&se!=0) set.add(fi/se);
                    }
                }
            }
        }
        for(int i=1;i<=8;i++){
            HashSet<Integer> set = list.get(i);
            if(set.contains(number)) return i;
        }
        
        return -1;
    }
}