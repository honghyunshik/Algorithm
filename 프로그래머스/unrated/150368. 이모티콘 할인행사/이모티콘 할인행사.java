import java.util.*;
class Solution {
    int maxPlus = 0;
    int maxSale = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        
        bruteForce(emoticons,0,new int[emoticons.length],users);
       
        return new int[]{maxPlus,maxSale};
    }
    
    int saleAmount(int price, int sale){
        
        return price*(100-sale)/100;
    }
    
    public void bruteForce(int[] emoticons, int idx, int[] saled, int[][] users){
        
        //모든 경우에 대해서 users 확인
        if(idx==emoticons.length){
            
            int tempPlus = 0;
            int tempSale = 0;
            for(int[] user:users){
                
                int userSale = 0;
                int userPlus = 0;
                for(int saleIdx=0;saleIdx<saled.length;saleIdx++){
                    
                    //할인율 넘으면 구매
                    if(user[0]<=saled[saleIdx]){
                        userSale += saleAmount(emoticons[saleIdx],saled[saleIdx]);
                        if(userSale>=user[1]){
                            userSale = 0;
                            userPlus = 1;
                            break;
                        }
                    }
                }
                tempPlus += userPlus;
                tempSale += userSale;
            }
            
            if(tempPlus>maxPlus){
                maxPlus = tempPlus;
                maxSale = tempSale;
            }else if(tempPlus==maxPlus){
                maxSale = Math.max(tempSale,maxSale);
            }
            return;
        }
        
        for(int sale=10;sale<=40;sale+=10){
            saled[idx] = sale;
            bruteForce(emoticons,idx+1,saled,users);
        }
    }
}