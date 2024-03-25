import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] numArr = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            answer += checkRow(i, numArr, n, m);
            answer += checkColumn(i, numArr, n, m);
        }

        System.out.println(answer);

    }

    public static int checkRow(int rowIdx, int[][] numArr, int n, int m) {
        int duplicate = 0;
        for (int i = 0; i < n - 1; i++) {
            if (numArr[rowIdx][i] == numArr[rowIdx][i + 1]) {
                duplicate++;
            }
        }

        if (duplicate + 1 >= m) {
            return 1;
        }
        return 0;
    }

    public static int checkColumn(int columnIdx, int[][] numArr, int n, int m) {
        int duplicate = 0;
        for (int i = 0; i < n - 1; i++) {
            if (numArr[i][columnIdx] == numArr[i + 1][columnIdx]) {
                duplicate++;
            }
        }

        if (duplicate + 1 >= m) {
            return 1;
        }
        return 0;
    }
}