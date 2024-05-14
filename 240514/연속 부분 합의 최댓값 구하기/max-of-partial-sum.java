import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] nums, dp;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        initialize();
        int maxAns = dp[0];

        for(int i = 1; i<n; i++){
            dp[i] = Math.max(nums[i] + dp[i-1], nums[i]);
            maxAns = Math.max(dp[i], maxAns);
        }

        System.out.print(maxAns);
    }

    public static void initialize(){
        for(int i = 0; i<n; i++){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = nums[0];
    }
}