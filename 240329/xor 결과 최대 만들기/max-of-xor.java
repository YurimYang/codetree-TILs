import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> xor = new ArrayList<>();
    static int n,m,maxAns;
    static int[] nums;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findCombination(1,0);
        System.out.println(maxAns);


    }

    public static void findCombination(int currNum, int cnt){
        if(currNum == n+1){
            if(cnt == m){
                maxAns = Math.max(maxAns,calXOR());
            }
            return;
        }

        xor.add(currNum);
        findCombination(currNum+1,cnt+1);
        xor.remove(xor.size()-1);

        findCombination(currNum+1, cnt);

    }

    public static int calXOR(){
        int answer = xor.get(0);
        for(int i = 1; i<xor.size(); i++){
            answer ^= xor.get(i);
        }
        return answer;
    }

}