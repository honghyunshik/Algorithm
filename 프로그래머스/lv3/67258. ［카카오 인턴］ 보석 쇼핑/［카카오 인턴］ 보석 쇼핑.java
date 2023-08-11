import java.util.*;


class Solution {

    public static int start=0,end=Integer.MAX_VALUE;

    public int[] solution(String[] gems) {

        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();      //set 개수 파악용
        for(String s:gems){
            set.add(s);
        }

        int len = set.size();
        int l=0,r=0;

        HashSet<String> check = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        while(l<gems.length&&r<gems.length){

        
            while(check.size()<len&&r<gems.length){
                map.put(gems[r],map.getOrDefault(gems[r],0)+1);
                check.add(gems[r]);
                r++;
            }
            if(check.size()==len){


                String val = gems[l];   //삭제될 값
                while(l<gems.length&&check.size()==len){
                    map.put(gems[l],map.get(gems[l])-1);
                    if(map.get(gems[l])==0) check.remove(gems[l]);
                    l++;
                }
                if(end-start>r-l){

                    start=l;
                    end=r;
                }
            }

        }
        answer[0] = start;
        answer[1] = end;

        return answer;
    }

}