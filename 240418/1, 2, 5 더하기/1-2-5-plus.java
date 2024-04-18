import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] plus = new int[]{1,2,5};
    static int[] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 1;


        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<3; j++){
                if(i - plus[j] >=0 ){
                    dp[i] += dp[i - plus[j]] % 10007;
                }
            }
        }

        System.out.print(dp[n]);
    }


}