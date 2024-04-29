import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int offset = 100;
    static int[][] grid = new int[1000][1000];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            createRec(x + offset, y + offset);
        }
        System.out.println(countTotal()); 
    }

    public static void createRec(int x, int y){
        for(int i = x; i<x+8; i++){
            for(int j = y; j<y+8; j++){
                grid[i][j]++;
            }
        }
    }

    public static int countTotal(){
        int answer = 0;
        for(int i = 0; i<1000; i++){
            for(int j = 0; j<1000; j++){
                if(grid[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}