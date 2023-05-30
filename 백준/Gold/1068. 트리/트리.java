
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        int root = 0;
        for(int i=0;i<n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1){
                root = i;
                continue;
            }
            list.get(parent).add(i);
        }
        int de = Integer.parseInt(br.readLine());
        if(root==de) System.out.println(0);
        else System.out.println(getLeaf(root,de));
    }

    private static int getLeaf(int n, int de){

        if(list.get(n).size()==0||list.get(n).size()==1&&list.get(n).get(0)==de) return 1;

        int sum = 0;
        for(int i=0;i<list.get(n).size();i++){
            int next = list.get(n).get(i);
            if(next==de) continue;
            sum+=getLeaf(next,de);
        }

        return sum;
    }
}
