import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(pq.size() >= 2){
            pick();
        }

        if(pq.size() == 0){
            System.out.println(-1);
        } else {
            System.out.println(pq.poll());
        }
        
    }

    public static void pick(){
        int n1 = pq.poll();
        int n2 = pq.poll();
        int sum = Math.abs(n1 - n2);
        if(sum != 0){
            pq.add(sum);
        }
    }
}