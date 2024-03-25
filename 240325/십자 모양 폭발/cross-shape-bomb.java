import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r,c,n;
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n][n];

        for(int i = 0; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        int bomb = numbers[r][c];
        makeZero(bomb);
        afterBomb();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void makeZero(int bomb){
        numbers[r][c] = 0;
        if(bomb > n) {
            bomb = n-1;
        }
        for(int i = 1; i<bomb; i++){
            if(c+i < n){
                numbers[r][c+i] = 0;
            }
            if(r+i < n){
                numbers[r+i][c] = 0;
            }
            if(c-i >= 0){
                numbers[r][c-i] = 0;
            }
            if(r-i >= 0){
                numbers[r-i][c] = 0;
            }
        }
    }

    public static void afterBomb(){
        for(int i = 0; i<n; i++){
            int[] tmp = new int[n];
            int endOfTmp = n-1;
            for(int j = n-1; j>=0; j--){
                if(numbers[j][i] == 0){
                    continue;
                }
                tmp[endOfTmp] = numbers[j][i];
                endOfTmp--;
            }
            for(int k = 0; k<n; k++){
                numbers[k][i] = tmp[k];
            }
        }
    }
}