import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanho_l = scores[0][0];
        int wanho_r = scores[0][1];
        int sum = wanho_l + wanho_r;
        Person[] arr = new Person[scores.length];
        for(int i=0;i<scores.length;i++){
            arr[i] = new Person(scores[i][0],scores[i][1]);
        }
        Arrays.sort(arr);
        
        int max = 0;
        for(Person p:arr){
                       //둘다 넘음
            if(max>p.right){
                
                if(p.left==wanho_l&&p.right==wanho_r) return -1;
            }else{
                max = Math.max(max,p.right);
                if(p.left+p.right>sum) answer++;
            }
        }
        return answer;
    }
}

class Person implements Comparable<Person>{
    int left, right;
    Person(int left, int right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Person o){
        if(o.left==this.left){
            return this.right-o.right;
        }
        return o.left - this.left;
    }
}