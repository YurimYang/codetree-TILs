import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] grid, visited, step;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //visited초기화
        visited = new int[n][m];
        step = new int[n][m];
        push(0, 0, 0);
        BFS();

        if(visited[n-1][m-1] > 0){
            System.out.println(step[n-1][m-1]);
        } else{
            System.out.println(-1);
        }






        
    }

    public static void BFS(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = currPoint.x + dx[i];
                int ny = currPoint.y + dy[i];

                if(canGo(nx, ny)){
                    visited[nx][ny] = 1;
                    step[nx][ny] = step[currPoint.x][currPoint.y] + 1;
                    push(nx, ny, step[nx][ny]);
                }
            }
        }


    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)){
            return false;
        } else if(visited[x][y] != 0 || grid[x][y] == 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<= x && x< n & 0 <= y && y < m;
    }

    public static void push(int x, int y, int step){
        queue.add(new Point(x, y, step));
    }
}

class Point{
    int x;
    int y;
    int step;

    public Point(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }
}