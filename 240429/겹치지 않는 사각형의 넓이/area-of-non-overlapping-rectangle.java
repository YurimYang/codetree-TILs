import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid = new int[2000][2000];
    static int offset = 1000;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        for(int i = 0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            maxX = Math.max(maxX, x1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y1);
            maxY = Math.max(maxY, y2);

            plusArea(x1 + offset,y1 + offset,x2 + offset,y2 + offset);
        }
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        minusArea(x1 + offset,y1 + offset,x2 + offset,y2 + offset); 
        System.out.println(countTotalArea());
    }

    public static void plusArea(int x1, int y1, int x2, int y2){
        for(int i = x1; i<x2; i++){
            for(int j = y1; j<y2; j++){
                grid[i][j]++;
            }
        }
    }

    public static void minusArea(int x1, int y1, int x2, int y2){
        for(int i = x1; i<x2; i++){
            for(int j = y1; j<y2; j++){
                grid[i][j] = 0;
            }
        }
    }

    public static int countTotalArea(){
        int answer = 0;
        for(int i = 0; i<maxX + offset; i++){
            for(int j = 0; j<maxY+ offset; j++){
                if(grid[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }


}