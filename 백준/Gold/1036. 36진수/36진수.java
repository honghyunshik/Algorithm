
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    static String[] arr;
    static PriorityQueue<BigInteger> pq = new PriorityQueue<>((a, b)->b.compareTo(a));
    static BigInteger answer = BigInteger.ZERO;
    static HashMap<Integer,Character> mapToChar = new HashMap<>();
    static HashMap<Character,Integer> mapToInt = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());

        int c = 'A';
        int a = '0';
        for(int i=0;i<36;i++){

            if(i<10) {
                mapToChar.put(i,(char)a);
                mapToInt.put((char) a,i);
                a++;
            }
            else{
                mapToChar.put(i,(char)c);
                mapToInt.put((char)c,i);
                c++;
            }

        }

        for(int i=0;i<36;i++){

            BigInteger sum = BigInteger.ZERO;
            for(int j=0;j<n;j++){
                BigInteger temp = BigInteger.ONE;
                for(int p=arr[j].length()-1;p>=0;p--){
                    if(i==0) answer = answer.add(temp.multiply(BigInteger.valueOf(mapToInt.get(arr[j].charAt(p)))));
                    if(arr[j].charAt(p)==mapToChar.get(i)){
                          sum = sum.add(temp.multiply(BigInteger.valueOf((35-mapToInt.get(arr[j].charAt(p))))));
                    }
                    temp = temp.multiply(BigInteger.valueOf(36));
                }
            }
            pq.add(sum);

        }
        for(int i=0;i<k;i++){

            BigInteger dif = pq.poll();
            answer = answer.add(dif);
        }
        System.out.println(to36(answer));

    }

    public static String to36(BigInteger num){

        StringBuilder sb = new StringBuilder();
        while(!num.equals(BigInteger.ZERO)){
            int enter = num.mod(BigInteger.valueOf(36)).intValue();
            sb.insert(0,mapToChar.get(enter));
            num = num.divide(BigInteger.valueOf(36));
        }
        if(sb.length()==0) return ("0");
        return sb.toString();
    }

}

