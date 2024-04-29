import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid = new int[100][100];
    static int offset = 100;
    //static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<int[][]> areas = new ArrayList<>();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            recArea(x1,y1,x2,y2);
        }        
        System.out.println(findTotalArea());
    }

    public static void recArea(int x1, int y1, int x2, int y2){
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0){
            x1 += offset;
            y1 += offset;
            x2 += offset;
            y2 += offset;
        }
        for(int i = y1; i<y2; i++){
            for(int j = x1; j<x2; j++){
                grid[j][i]++;
            }
        }
    }

    public static int findTotalArea(){
        int answer = 0;
        for(int i = 0; i< 100; i++){
            for(int j = 0; j<100; j++){
                if(grid[i][j] > 0){
                     answer ++;
                 }
            }
        }
        return answer;
    }
}