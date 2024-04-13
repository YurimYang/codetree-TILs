import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static PriorityQueue<Integer> pq;
    static int[] num;
    static double max = Double.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        pollNum();
        System.out.println(String.format("%.2f", max)); 
    }

    public static void pollNum(){
        for(int k = 1; k<n-2; k++){
            pq = new PriorityQueue<>();
            int sum = 0;
            for(int j = k; j<n; j++){
                pq.add(num[j]); 
            }
            pq.poll();
            int size = pq.size();
            for(int i = 0; i<size; i++){
                sum += pq.poll();
            }
            max = Math.max(max, sum/size);
        }
    }
}
//k : 1~n-2