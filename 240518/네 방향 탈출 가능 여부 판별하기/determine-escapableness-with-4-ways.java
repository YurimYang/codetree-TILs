import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] grid, visited;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //visited 초기화
        visited = new int[n][m];
        queue.add(new Point(0,0));
        visited[0][0] = 1;
        BFS();

        if(visited[n-1][m-1] > 0){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void BFS(){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            Point currV = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = currV.x + dx[i];
                int ny = currV.y + dy[i];

                if(canGo(nx, ny)){
                    visited[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)){
            return false;
        } else if(grid[x][y] == 0 || visited[x][y] == 1){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y <m;
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