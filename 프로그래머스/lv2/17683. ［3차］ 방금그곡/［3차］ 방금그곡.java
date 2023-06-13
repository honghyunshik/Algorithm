class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "";
        int backDif = -1;
        m = replaceStr(m);
         
        for(String str:musicinfos){
            
            String[] temp = str.split(",");
            String start = temp[0];
            String end = temp[1];
            int dif = getTime(start,end);
            String title = temp[2];
            String melody = temp[3];
            
            melody = replaceStr(melody);  
            int size = melody.length();
            StringBuilder multiMelody = new StringBuilder();
            
            if(size<dif){
                
                for(int i=0;i<dif/size;i++){
                    multiMelody.append(melody);
                }
                multiMelody.append(melody.substring(0,dif%size));
            }else{
                multiMelody.append(melody.substring(0,dif));
            }
            
            if(multiMelody.toString().contains(m)&&dif>backDif)             {
                backDif = dif;
                answer = title;
            }
        }
        if(backDif==-1) return "(None)";
        return answer;
    }
    
    private String replaceStr(String m){
        
        m = m.replaceAll("A#","L");
        m = m.replaceAll("C#","H");
        m = m.replaceAll("D#","I");
        m = m.replaceAll("G#","J");
        m = m.replaceAll("F#","K");
      
        return m;
        
    }
    
    private int getTime(String start, String end){
        
        int startHour = Integer.parseInt(start.split(":")[0]);
        int startMinute = Integer.parseInt(start.split(":")[1]);
        int endHour = Integer.parseInt(end.split(":")[0]);
        int endMinute = Integer.parseInt(end.split(":")[1]);
        
        
        return (endHour-startHour)*60 + endMinute-startMinute;
        
    }
}