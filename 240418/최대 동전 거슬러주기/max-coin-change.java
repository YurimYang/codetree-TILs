import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st; 
    static int n,m;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //동전 초기화
        coin = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m+1];
        initial();
        for(int i = 1; i<m+1; i++){
            for(int j = 0; j<n; j++){
                if(i-coin[j] >=0){
                    dp[i] = Math.max(dp[i], dp[i-coin[j]]+1);
                }
            }
        }

        int ans = dp[m];
        if(ans == Integer.MIN_VALUE){
            System.out.print(-1);
        }else{
            System.out.print(ans);
        }    
    }

    public static void initial(){
        for(int i = 1; i<m+1; i++){
            dp[i] = Integer.MIN_VALUE;
        }
    }

    
}