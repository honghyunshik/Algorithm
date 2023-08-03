class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length==1) return sticker[0];
        int[] dp_start_0 = new int[sticker.length];
        int[] dp_start_1 = new int[sticker.length];
        dp_start_0[0] = sticker[0];
        dp_start_0[1] = Math.max(sticker[0],sticker[1]);
        for(int i=2;i<sticker.length-1;i++){
            dp_start_0[i] = Math.max(sticker[i]+dp_start_0[i-2],dp_start_0[i-1]);
        }
        dp_start_1[1] = sticker[1];
        for(int i=2;i<sticker.length;i++){
            dp_start_1[i] = Math.max(sticker[i]+dp_start_1[i-2],dp_start_1[i-1]);
        }
        return Math.max(dp_start_0[sticker.length-2],dp_start_1[sticker.length-1]);
    }
}