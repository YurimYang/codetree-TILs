import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] grid;
    static int r,c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new String[r][c];
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<c; j++){
                grid[i][j] = st.nextToken();
            }
        }

        int ans = 0;

        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                for(int k = i+1; k<r-1; k++){
                    for(int z = j+1; z<c-1; z++){
                        if(!grid[0][0].equals(grid[i][j]) && 
                            !grid[i][j].equals(grid[k][z]) && 
                            !grid[k][z].equals(grid[r-1][c-1])){
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.print(ans);   
    }
}