public class Solution {



    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        //n,m은 각각 세로 좌표, 가로 좌표
        //x,y는 출발 위치를 뜻하는 좌표
        //r,c 는 탈출 지점을 나타내는 좌표
        //k는 탈출해야 하는 이동거리

        String answer = "";
        int minNum = Math.abs(x-r) + Math.abs(y-c);     //최소 걸리는 시간
        if(minNum%2!=k%2||minNum>k) return "impossible";        //최소 걸리는 시간보다 k가 작거나 2로 나누엇을때 나머지가 다를경우 불가능

        //최대한 d, l, r , u순서대로 이동해야 한다
        //얼마나 많이 d를 이동할 수 있냐?
        int spare = k-minNum;       //여유분 -> 이만큼은 목표치 외에 이동할 수 있다

        //목표로 가는길에 d가 있다면 우선 이동


        int downCount = 0;
        int leftCount = 0;
        boolean isDownFirst = true, isLeftFirst = true, isRightFirst = true, isUpFirst = true;
        //여유분만큼 d -> l -> r -> u 순서대로 이동
        if(spare>0){
            //아래로 이동하는것이 가능한가? -> 끝이 아니거나 or 돌아올 수 있을만큼 아래로 이동
            if(x<n){
                //우선 도착지까지 이동
                for(int i=0;i<r-x;i++) {
                    answer += "d";
                }
                if(r>x){
                    x = r;        //x는 목표치 r로 이동했다
                }
                //그다음에 최대한 내려갈 수 있을만큼 아래로 이동
                for(;x<n&&downCount<spare/2;downCount++){
                    answer+="d";
                    x++;
                }

                spare -= downCount*2;

            }
            //왼쪽으로 이동하는 것이 가능한가?
            if(y>1){
                //우선 도착지까지 이동
                for(int i=0;i<y-c;i++) {
                    answer += "l";
                }
                if(y>c){
                    y = c;        //y는 목표치 c로 이동했다
                }

                //최대한 왼쪽으로 이동
                for(;y>1&&leftCount<spare/2;leftCount++){
                    answer+="l";
                    y--;
                }
                spare -= leftCount*2;

            }
            //현재까지 spare가 남아있다면 왕복으로 지워주야아 한다 -> rl이 먼저, 그다음에 ud
            if(spare>0&&y<m){
                for(int i=0;i<spare/2;i++){
                    answer += "rl";
                }
                spare = 0;
            }

            for(int i=0;i<c-y;i++){
                answer += "r";

            }

            if(spare>0){
                for(int i=0;i<spare/2;i++){
                    answer += "ud";
                }
            }

            for(int i=0;i<x-r;i++){
                answer += "u";
            }
        }else{
            for(int i=0;i<r-x;i++){
                answer += "d";
            }
            for(int i=0;i<y-c;i++){
                answer += "l";
            }
            for(int i=0;i<c-y;i++){
                answer += "r";
            }
            for(int i=0;i<x-r;i++){
                answer += "u";
            }
        }







        return answer;
    }
}
