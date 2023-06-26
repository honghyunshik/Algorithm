import java.util.*;
class Solution {
    public String solution(String s) {
     
        s += "k";
        String[] arr = s.split(" ");
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i!=0) sb.append(" ");
            if(arr[i].equals("")) continue;
            if(arr[i].charAt(0)-48>=0&&arr[i].charAt(0)-48<=9){
                sb.append(arr[i].toLowerCase());
            }else{
                sb.append(arr[i].substring(0,1).toUpperCase());
                sb.append(arr[i].substring(1,arr[i].length()).toLowerCase());
            }
            
        }
     
        return sb.toString().substring(0,sb.length()-1);
    }
}