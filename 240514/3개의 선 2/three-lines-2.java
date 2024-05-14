import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid;
    static int[][] cover;
    static List<line> pointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        grid = new int[11][11];
        cover = new int[11][11];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grid[x][y] = 1;
            pointList.add(new line("x", x));
            pointList.add(new line("y", y));
        }
        
        int answer = 0;
        for(int i = 0; i<pointList.size(); i++){
            for(int j = i+1; j<pointList.size(); j++){
                for(int z = j+1; z<pointList.size(); z++){
                    line firstLine = pointList.get(i);
                    line secondLine = pointList.get(j);
                    line thirdLine = pointList.get(z);
                    cover = grid;

                    int[][] cover1 = coverUp(cover, firstLine);
                    int[][] cover2 = coverUp(cover1, secondLine);
                    int[][] cover3 = coverUp(cover2, thirdLine);

                    if(isAllErased(cover3)){
                        answer = 1;
                        break;
                    } 
                    cover = grid;
                }
            }
        } 
        System.out.print(answer);
    }

    public static int[][] coverUp(int[][] cover, line lines){
        if(lines.l == "x"){
            for(int k = 0; k<10; k++){
                cover[lines.n][k] = 0;
            }
        } else if (lines.l == "y"){
            for(int k = 0; k<10; k++){
                cover[k][lines.n] = 0;
            }
        }
        return cover;
    }

    public static boolean isAllErased(int[][] cover){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(cover[i][j] != 0){
                   return false;
                }
            }
        }
        return true;
    }
}
class line{
    String l;
    int n;

    public line(String l, int n){
        this.l = l;
        this.n = n;
    }

}