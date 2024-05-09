import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    
    // dp[i][j] : 지금까지 i번째 보석까지 고려해봤고,
    //            지금까지 고른 보석 무게의 합이 j였을 때 
    //            얻을 수 있는 최대 가치
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];
    
    public static int n, m;
    
    public static int[] weight = new int[MAX_N + 1];
    public static int[] value = new int[MAX_N + 1];
    
    public static void initialize() {
        // 최대를 구하는 문제이므로, 
        // 초기에는 전부 INT_MIN을 넣어줍니다.
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                dp[i][j] = INT_MIN;
        
        // 초기 조건으로
        // 아직 아무런 보석도 고려해보지 않은 상태를 정의합니다.
        // 따라서 지금까지 0번째 보석까지 고려해봤고,
        // 지금까지 고른 보석 무게의 합이 0이었을 때
        // 가치를 0만큼 얻었으므로
        // dp[0][0] = 0을 초기 조건으로 설정합니다.
        dp[0][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        initialize();

        // 지금까지 i번째 보석까지 고려해봤고,
        // 지금까지 고른 보석 무게의 합이 j였을 때 
        // 얻을 수 있는 최대 가치를 계산합니다.
        for(int i = 1; i <= n; i++){
            // 이런 상황을 만들기 위한 선택지는 크게 2개 입니다.
            
            // Case 1
            // i번 보석을 배낭에 집어 넣어 무게의 합이 j가 된 경우입니다.
            // 이 경우에는 i번 보석을 포함하여 무게의 합이 j가 되어야 하므로
            // i - 1번째까지 고려하여 고른 보석 무게의 합이 j - weight[i]였어야 합니다.
            // 따라서 이 상황에서의 최대 가치를 의미하는 dp[i - 1][j - weight[i]]에
            // 새로 얻게 되는 i번 보석의 가치 value[i]를 더한 값이 새로운 선택지가 됩니다. 
            // 단, j < weight[i]인 경우에는 i번째 보석을 추가하여 무게가 j가 될 수 없으므로
            // j >= weight[i]인 경우에만 가능합니다.

            // Case 2
            // i번 보석을 선택하지 않고 무게의 합이 j가 된 경우입니다.
            // 이 경우에는 i번 보석을 제외하고 무게의 합이 j가 되어야 하므로
            // i - 1번째까지 고려하여 고른 보석 무게의 합이 j였어야만 합니다. 
            // 따라서 이 상황에서의 최대 가치를 의미하는 dp[i - 1][j] 값이 하나의 선택지가 됩니다.

            for(int j = 0; j <= m; j++) {
                // j >= weight[i]인 경우에는 Case 1, Case 2 중 더 좋은 값을 선택합니다.
                if(j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                
                // j < weight[i]인 경우에는, Case 2만 가능합니다.
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // n개의 보석까지 전부 고려해봤을 때
        // 무게의 합이 m을 넘지 않는 경우를 전부 조사하여
        // 그 중 최댓값을 선택합니다.

        int ans = 0;

        for(int j = 0; j <= m; j++)
            ans = Math.max(ans, dp[n][j]);

        System.out.print(ans);
    }
}