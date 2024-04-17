import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coin = new int[n+1];
        dp = new int[m+1];

        st = new StringTokenizer(br.readLine());    
        for(int i = 1; i<=n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        initial();

        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<=n; j++){
                if(i - coin[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        int min = dp[m];

        if(min == Integer.MAX_VALUE){
            min = -1;
        }

        System.out.print(min);
    }

    public static void initial(){
        for(int i = 0; i<=m; i++){
            dp[i] = Integer.MAX_VALUE;
        } 

        dp[0] = 0;
    }
}