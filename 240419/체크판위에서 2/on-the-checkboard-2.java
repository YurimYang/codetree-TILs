import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] grid;
    static Queue<Point> q = new LinkedList<>();
    static int r,c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new String[r+1][c+1];
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<c; j++){
                grid[i][j] = st.nextToken();
            }
        }

        q.add(new Point(0,0));
        int ans = 0;


        while(!q.isEmpty()){
            Point currPoint = q.poll();
            int x = currPoint.x;
            int y = currPoint.y;
            for(int k = x+1; k<r; k++){
                for(int z = y+1; z<c; z++){
                    if(!grid[x][y].equals(grid[k][z])){
                        q.add(new Point(k,z));
                        if(k==r-1 && z ==c-1 && x !=0 && y!=0){
                            ans++;
                        } 
                    } 
                }
            }
        }

        System.out.print(ans);


        
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}