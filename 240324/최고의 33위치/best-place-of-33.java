import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int numCoin = 0;
        int[][] xy = new int[n][n];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            if(i >= n || i+1 >= n || i+2 >= n){
                break;
            }
            numCoin = Math.max(numCoin,checkCoin(xy,i));
        }
        System.out.println(numCoin);
    }

    public static int checkCoin(int[][] xy, int x){
        int maxCoin = 0;
        for(int i = x; i<x+3; i++){
            for(int j = x; j<x+3; j++){
                if(xy[i][j] == 1){
                    maxCoin++;
                }
            }
        }
        return maxCoin;
    }
}