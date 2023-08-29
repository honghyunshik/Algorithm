
import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {

        int[] list = new int[e+1];
        yaksu(list);
        int[] answer = new int[starts.length];

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<starts.length;i++){
            map.put(starts[i],i);
        }
        Arrays.sort(starts);
        int idx = 0;
        int max = 0;
        for(int i=0;i<starts.length;i++){
            if(idx<starts[i]){
                idx = 0;
                max = 0;
                for(int j=starts[i];j<=e;j++){
                    if(max<list[j]){
                        idx = j;
                        max = list[j];
                    }
                }
            }
            answer[map.get(starts[i])] = idx;
        }

        return answer;
    }

    public void yaksu(int[] list){
        int e = list.length-1;
        for(int i=1;i<=e;i++){
            for(int j=1;j<=e/i;j++){
                list[i*j]++;
            }
        }

    }
}