import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] blocks = new int[n+1];

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = n = Integer.parseInt(st.nextToken());
            int b = n = Integer.parseInt(st.nextToken());
            for(int dir = a; dir<=b; dir++){
                blocks[dir]++;
            }
        }

        int maxAns = Integer.MIN_VALUE;
        for(int i = 1; i<n+1; i++){
            maxAns = Math.max(maxAns, blocks[i]);
        }
        System.out.print(maxAns);
    }
}