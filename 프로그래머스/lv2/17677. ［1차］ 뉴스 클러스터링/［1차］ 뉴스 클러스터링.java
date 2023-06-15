import java.util.*;
class Solution {
    
    HashMap<String,Integer> str1Map = new HashMap<>();
    HashMap<String,Integer> str2Map = new HashMap<>();
    HashMap<String,Integer> unionMap = new HashMap<>();
    HashMap<String,Integer> interMap = new HashMap<>();
    
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        MakeMap(str1,1);
        MakeMap(str2,2);
        if(unionMap.size()==0&&interMap.size()==0) return 65536;
        int union = 0;
        int intersect = 0;
        for( String key : unionMap.keySet() ){
            union += unionMap.get(key);
        
      }
        
        for( String key : interMap.keySet() ){
            intersect += interMap.get(key);
        
      }
        double d = (double)intersect/union;
        return (int)Math.floor(d*65536);
    }
    
    private void MakeMap(String str, int num){
        
        for(int i=0;i<str.length()-1;i++){
            
            String temp = str.substring(i,i+2);
            if(!check(temp)) continue;
            
            if(num==1){
                str1Map.put(temp,str1Map.getOrDefault(temp,0)+1);
            }else{
                str2Map.put(temp,str2Map.getOrDefault(temp,0)+1);
            }
            int l = str1Map.getOrDefault(temp,0);
            int r = str2Map.getOrDefault(temp,0);
            int max = Math.max(l,r);
            int min = Math.min(l,r);
            unionMap.put(temp,max);
            if(min!=0){
                interMap.put(temp,min);
            } 
            
        }
    }
    
    private boolean check(String str){
    
        if(str.length()<2) return false;
        boolean flag1 = false;
        boolean flag2 = false;
        for(char i='a';i<='z';i++){
            if(str.charAt(0)==i) flag1 = true;
            if(str.charAt(1)==i) flag2 = true;
            if(flag1&&flag2) return true;
        }
        return false;
    }
}