import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m,answer = 0;
    static int[][] grid;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        m = Integer.parseInt(st.nextToken()); //연속해야하는 수

        //grid 초기화
        grid = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        } 
        //정답 
        countNumberByRow();
        countNumberByCol();
        System.out.println(answer);
    }

    //행 기준 m개 이상 개수 세기
    public static void countNumberByRow(){
        for(int i = 0; i<n; i++){
            int duplicate = 1;
            int maxCount = 1;
            for(int j = 0; j<n-1; j++){
                if(grid[i][j] == grid[i][j+1]){
                    duplicate++;
                } else {
                    duplicate = 1;
                }
                maxCount = Math.max(maxCount,duplicate);
            }
            if(maxCount >= m){
                answer++;
            }

        }
    }

    //열 기준 m개 이상 개수 세기
    public static void countNumberByCol(){
        for(int j = 0; j<n; j++){
            int duplicate = 1;
            int maxCount = 1;
            for(int i = 0; i<n-1; i++){
                if(grid[i][j] == grid[i+1][j]){
                    duplicate++;
                } else {
                    duplicate = 1;
                }
                maxCount = Math.max(maxCount,duplicate);
            }
            if(maxCount >= m){
                answer++;
            }
        }
    }
}