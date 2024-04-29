import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid = new int[2000][2000];
    static int offset = 1000;

    public static void main(String[] args) throws IOException {
        for(int i = 0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            createRec(i+1, x1+offset, y1+offset, x2+offset, y2+offset);
        }
        System.out.println(findFristRec());
        
    }
    public static void createRec(int num, int x1, int y1, int x2, int y2){
        for(int i = x1; i<x2; i++){
            for(int j = y1; j<y2; j++){
                if(grid[i][j] == num-1){
                    grid[i][j] = num;
                } 
            }
        }
    }

    public static int findFristRec(){
        int answer = 0 ;
        for(int i = 0; i<2000; i++){
            for(int j = 0; j<2000; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2){
                    answer++;
                }
            }
        }
        return answer;
    }
}