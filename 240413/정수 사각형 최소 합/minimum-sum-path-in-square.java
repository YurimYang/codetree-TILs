import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] num, sum;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        num = new int[n+1][n+1];
        sum = new int[n+1][n+1];
        for(int i = 1; i< n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<n+1; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Count();
        System.out.print(sum[n][1]);
    }

    public static void Count(){
        sum[1][n] = num[1][n];
        for(int i = n-1; i> 0; i--){
            sum[1][i] = sum[1][i+1] + num[1][i];
        }
        for(int i = n-1; i >0; i--){
            sum[i][n] = sum[i+1][n] + num[i][n];
        }
        for(int i = 1; i<n+1; i++){
            for(int j = n; j>0; j--){
                if(sum[i][j] == 0){
                    sum[i][j] = sum[i-1][j] + num[i][j];
                } 
            }
        }
    }
}