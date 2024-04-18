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

        //coin 생성
        coin = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }

        //초기화 진행
        dp = new int[m+1];
        initial();
        for(int j = 0; j<n; j++){
            for(int i = m; i>=0; i--){
                if(i-coin[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
                }
            }
        }

        int ans = dp[m];
        if(ans == 10001){
            System.out.print(-1);
        } else{
            System.out.print(ans);
        } 
    }

    public static void initial(){
        for(int i = 1; i<m+1; i++){
            dp[i] = 10001;
        }
        dp[0] = 0;
    }
}