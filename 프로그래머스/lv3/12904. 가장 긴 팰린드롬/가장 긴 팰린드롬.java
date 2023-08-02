class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i=1;i<s.length();i++){
            
            int l = i-1;
            int r = i;
            int temp = 2;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                answer = Math.max(answer,temp);
                temp+=2;
            }
            l = i-1;
            r = i+1;
            temp = 3;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                answer = Math.max(answer,temp);
                temp+=2;
            }
        }

        
        return answer;
    }
}