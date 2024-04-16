import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        num = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<i; j++){
                if(num[j] < num[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }            
        }

        Arrays.sort(dp);
        System.out.print(dp[n]);
    }
}