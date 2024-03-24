import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int maxOfCoin = 0;
        int[][] xy = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<= n-3; i++){
            for(int j =0; j<=n-3; j++){
                maxOfCoin = Math.max(maxOfCoin, checkCoin(xy, i,j));
            }
        }
        System.out.println(maxOfCoin);
    }

    public static int checkCoin(int[][] xy, int x, int y) {
        int numOfCoin = 0;
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++){
                if(xy[i][j] == 1){
                    numOfCoin++;
                }
            }
        }
        return numOfCoin;
    }
}