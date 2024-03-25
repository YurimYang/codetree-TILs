import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        m = Integer.parseInt(st.nextToken()); //블록의 크기 (1*m크기)
        k = Integer.parseInt(st.nextToken()); //어느 열부터 떨어지는지
        numbers = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int targetIdx = findRIdx();
        for(int j = k; j<=m+k-1; j++){
            numbers[targetIdx][j] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(numbers[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int findRIdx(){
        int rIdx = 0;
        for(int i = 1; i<=n; i++){
            int cntZero = 0;
            for(int j = k; j<=m+k-1; j++){
                if(numbers[i][j] == 0){
                    cntZero++;
                }
            }
            if(cntZero == m){
                rIdx++;
            } else{
                break;
            }
        }
        return rIdx;
    }
}