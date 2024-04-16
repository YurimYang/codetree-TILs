import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] num, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        num = new int[n];
        dp = new int[n];

        for(int i = 0 ; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<n; i++){
            dp[i] = 1;
            for(int j = 0; j< i; j++){
                if(num[j] > num[i]){
                    dp[i] = Math.max(dp[j], dp[j] + 1);
                } 
            }
        }

        Arrays.sort(dp);
        System.out.print(dp[n-1]);
    }
}