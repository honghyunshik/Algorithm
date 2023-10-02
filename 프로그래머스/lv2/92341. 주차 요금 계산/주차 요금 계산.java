import java.util.*;

class Solution {
    
    HashMap<String,Integer> feeMap = new HashMap<>();
      
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String,Integer> inTime = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(String record:records){
            
            String[] temp = record.split(" ");
            
            int time = toMinute(temp[0]);
            String car = temp[1];
            if(!set.contains(car)) pq.add(car);
            set.add(car);
            if(temp[2].equals("IN")){
                inTime.put(car,time);
            }else{
                int in = inTime.get(car);
                feeMap.put(car,feeMap.getOrDefault(car,0)+time-in);
                inTime.put(car,null);
            }
        }
        for(String car:set){
            Integer in = inTime.get(car);
            if(in!=null){
                feeMap.put(car,feeMap.getOrDefault(car,0)+toMinute("23:59")-in);
            }
        }
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            String car = pq.poll();
            answer[idx++] = countFee(car,fees);
        }
        
        return answer;
    }
    
    //요금 계산하는 함수
    int countFee(String car, int[] fees){
        int minute = feeMap.get(car);
        
        if(minute>fees[0]){
            int multiple = (minute-fees[0])%fees[2]==0?(minute-fees[0])/fees[2]:(minute-fees[0])/fees[2]+1;
            return fees[1] + multiple*fees[3]; 
        }
        return fees[1];
        
    }
    
        
    //시간 -> 분으로 변환
    int toMinute(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
}