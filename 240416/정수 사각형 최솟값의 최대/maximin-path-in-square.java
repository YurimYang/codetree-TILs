import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] grid, dp;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        //이후, 행과 열로 둘러싸인 곳들의 최소값을 구해준다.
        for(int i = 1; i<n; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = Math.min(Math.max(dp[i-1][j], dp[i][j-1]), grid[i][j]);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }

    //행 1줄, 열 1줄을 초기화 한다.
    public static void initialize() {
        dp[0][0] = grid[0][0];
        for(int i = 1; i<n; i++){
            dp[0][i] = Math.min(dp[0][i-1], grid[0][i]);
        }

        for(int i = 1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][0], grid[i][0]);
        }
    }

}