import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid = new int[1000][1000];
    static int offset = 200;
    //static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int finAns = 0;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            finAns += recArea(x1,y1,x2,y2);
        }        
        System.out.println(finAns);
    }

    public static int recArea(int x1, int y1, int x2, int y2){
        int answer = 0;
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0){
            x1 += offset;
            y1 += offset;
            x2 += offset;
            y2 += offset;
        }
        for(int i = y1; i<y2; i++){
            for(int j = x1; j<x2; j++){
                if(grid[j][i] == 0){
                    answer++;
                }
                grid[j][i]++;
            }
        }
        return answer;
    }
}