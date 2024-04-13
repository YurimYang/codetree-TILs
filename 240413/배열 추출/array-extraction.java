import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> numQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k > 0){
                numQueue.add(k);
            } else if (k == 0){
                if(numQueue.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(numQueue.poll());
                } 
            }   
        }
    }
}