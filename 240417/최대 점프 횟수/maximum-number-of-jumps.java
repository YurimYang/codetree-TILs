import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] num, dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        num = new int[n];
        dp = new int[n];

        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<n; i++){
            dp[i] = 0;
            for(int j = 0; j<i; j++){
                if(i-j >= num[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}