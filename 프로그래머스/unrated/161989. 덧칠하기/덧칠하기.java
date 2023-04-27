import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        //n -> 구역 수  m -> 롤러 길이
        int answer = 0;
        int now = -1;
        Arrays.sort(section);
        for(int i=0;i<section.length;i++){
            if(section[i]>now){
                answer++;
                now = m-1 + section[i];
            }
        }
        return answer;
    }
}