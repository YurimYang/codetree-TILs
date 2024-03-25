import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] numbers = new int[3][n];

        for(int i = 0; i<3 ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(t > 0){
            int firstTmp = numbers[0][n-1];
            int secondTmp = numbers[1][n-1];
            int thirdTmp = numbers[2][n-1];

            for(int i = n-1; i>0; i--){
                numbers[0][i] = numbers[0][i-1];
                numbers[1][i] = numbers[1][i-1];
                numbers[2][i] = numbers[2][i-1];
            }
            numbers[0][0] = thirdTmp;
            numbers[1][0] = firstTmp;
            numbers[2][0] = secondTmp;
            t--;
        }

        for(int i = 0; i<3;i++){
            for(int j = 0; j<n; j++){
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println("");
        }
    }
}