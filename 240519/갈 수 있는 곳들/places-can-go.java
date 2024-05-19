import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, answer = 0;
    static int[][] grid, visited;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작점 초기화
        visited = new int[n][n];
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1 ;
            if(canGo(x,y)){
                visited[x][y] = 1;
                answer++;
                queue.add(new Point(x, y));
                BFS();
            }
        }
        
        System.out.print(answer);
    }

    public static void BFS(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[] {0,0,-1,1};

        while(!queue.isEmpty()){
            Point currP = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = currP.x + dx[i];
                int ny = currP.y + dy[i];

                if(canGo(nx, ny)){
                    visited[nx][ny] = 1;
                    answer++;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)){
            return false;
        } else if (grid[x][y] == 1 || visited[x][y] != 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0 <= x && x<n && 0 <= y && y < n;
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