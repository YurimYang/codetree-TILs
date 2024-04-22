import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] grid;
    static int r,c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); //세로변 (행)
        int c = Integer.parseInt(st.nextToken()); //가로변 (열)

        //grid 초기화
        grid = new String[r][c];
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<c; j++){
                grid[i][j] = st.nextToken(); 
            }
        }


        //완전탐색
        int ans = 0;
        for(int i = 1; i<r-1; i++){
            for(int j = 1; j<c-1; j++){
                if(!grid[0][0].equals(grid[i][j])){
                    for(int k = i+1; k<r-1; k++){
                        for(int z = j+1; z<c-1; z++){
                            if(!grid[k][z].equals(grid[i][j]) &&
                                !grid[r-1][c-1].equals(grid[k][z])){
                                    ans++;
                                }
                        }
                    }
                }
            }
        }
        System.out.print(ans);
    }
}