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
        num = new int[n];
        dp = new int[n];

        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i = 1; i<n; i++){
            int max = Integer.MIN_VALUE;
            int idx = 0;
            boolean isChanged = false;
            for(int j = 0; j<i; j++){
                if(num[j] < num[i]){
                    max = Math.max(max, num[j]); 
                    idx = j;
                    isChanged = true;
                }  
            }
            if(isChanged){
                dp[i] = dp[idx] + 1;
            } else {
                dp[i] = 0;
            }
            
        }

        Arrays.sort(dp);
        System.out.print(dp[n-1]);
    }
}