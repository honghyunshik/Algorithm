import java.util.*;

class Solution {


    public String solution(int n, int k, String[] cmd) {

        boolean[] deleted = new boolean[n];
        Stack<int[]> stack = new Stack<>();

        //0은 prev Index, 1은 next Index
        int[][] array = new int[n][3];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            array[i] = new int[]{i-1,i+1};
            sb.append("O");
        }


        for(int i=0;i<cmd.length;i++){

            String now = cmd[i];
            if(now.equals("C")){

                int prev = array[k][0];
                int next = array[k][1];
                //prev의 next는 next를 가리킴
                if(prev!=-1) array[prev][1] = next;
                //next의 prev는 prev를 가리킴
                if(next!=n) array[next][0] = prev;
                stack.add(new int[]{prev,k,next});
                sb.setCharAt(k,'X');
                if(next!=n) k = next;
                else k = prev;

            }else if(now.equals("Z")){

                int[] temp  = stack.pop();
                int prev = temp[0];
                int next = temp[2];
                if(prev!=-1) array[prev][1] = temp[1];
                if(next!=n) array[next][0] = temp[1];
                sb.setCharAt(temp[1],'O');

            }else{
                String command = now.split(" ")[0];
                int dis = Integer.parseInt(now.split(" ")[1]);
                if(command.equals("D")) {
                    while(dis>0){
                        dis--;
                        k = array[k][1];
                    }
                }
                else{
                    while(dis>0){
                        dis--;
                        k = array[k][0];
                    }
                }
            }
        }

        return sb.toString();
    }
}