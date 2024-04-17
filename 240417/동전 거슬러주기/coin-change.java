import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());    
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for(int i = 1; i<m+1; i++){
            initial(i);
            for(int j = 0; j<n; j++){
                if(i - coin[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
    
            }
        }

        int max = 0;
        for(int i = 0; i<m+1; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }

    public static void initial(int i){
        dp[i] = Integer.MIN_VALUE;
        
    }
}