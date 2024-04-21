import java.util.Scanner;

public class Main {
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    
    // dp[i][j] : 지금까지 i번째 수까지만 고려해봤을 때,
    //            고른 수의 합을 j로 만드는 것이 가능하면 true
    //            불가능하면 false
    public static boolean[][] dp = new boolean[MAX_N + 1][MAX_M + 1];
    
    public static void initialize() {
        // 초기 조건으로
        // 아직 아무런 수도 고려해보지 않은 상태를 정의합니다.
        // 따라서 지금까지 0번째 수까지 고려해기에
        // 지금까지 선택한 수의 합이 0이므로
        // dp[0][0] = true가 됩니다.
        dp[0][0] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        initialize();

        // 지금까지 i번째 수까지 고려해봤고,
        // 지금까지 고른 수들의 합이 j가 되는게 가능한지를 판단합니다.
        for(int i = 1; i <= n; i++){
            // 이런 상황을 만들기 위한 선택지는 크게 2개 입니다.
            
            // Case 1
            // i번 수를 선택하여 합이 j가 된 경우입니다.
            // 이 경우에는 i번 수를 포함하여 합이 j가 되어야 하므로
            // i - 1번째까지 고려하여 고른 수들의 합이 j - arr[i]였어야 합니다.
            // 단, j < arr[i]인 경우에는 i번째 수를 추가하여 합이 j가 될 수 없으므로
            // j >= arr[i]인 경우에만 가능합니다.

            // Case 2
            // i번 수를 선택하지 않고 합이 j가 된 경우입니다.
            // 이 경우에는 i번 수를 제외하고 합이 j가 되어야 하므로
            // i - 1번째까지 고려하여 고른 수들의 합이 j였어야만 합니다. 
            for(int j = 0; j <= m; j++) {
                // Case 1
                if(j >= arr[i] && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;
                
                // Case 2
                if(dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        // n개의 수까지 전부 고려해봤을 때
        // 정확히 합이 m이 되는 것이 가능한지 판단합니다.
        if(dp[n][m])
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}