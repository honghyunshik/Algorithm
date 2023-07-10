import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Talk> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Talk(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int ans = 0;
        int nowTime = 0;
        while(!pq.isEmpty()){
            Talk now = pq.poll();
            int start = now.start;
            int end = now.end;
            if(nowTime<=start){
                ans++;
                nowTime = end;
            }

        }

        System.out.println(ans);

    }
}

class Talk implements Comparable<Talk>{
    int start, end;
    Talk(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Talk o) {
        if(this.end==o.end){
            return this.start-o.start;
        }
        return this.end-o.end;
    }
}