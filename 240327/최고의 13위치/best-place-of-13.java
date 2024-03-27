import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxCoin = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<=n-3; j++){
                maxCoin = Math.max(maxCoin, countCoin(i,j));
            }
        }
        System.out.println(maxCoin);
    }

    public static int countCoin(int x, int y){
        int coin = 0;
        for(int i = y; i <= y+2; i++){
            if(nums[x][i] == 1){
                coin++;
            }
        }
        return coin;
    }
}