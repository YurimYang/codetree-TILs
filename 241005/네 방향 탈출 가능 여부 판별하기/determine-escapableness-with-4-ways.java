import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m = 0;
    static int[][] graph;
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Point(0,0));
        visited[0][0] = 1;
        bfs();
        if(visited[n-1][m-1] == 1){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void bfs(){
        int[] dx = {-1,1,0,0}; //상하좌우
        int[] dy = {0,0,-1,1};
        
        while(!queue.isEmpty()){
            Point curr = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

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
        } else if(graph[x][y] == 0 || visited[x][y] != 0){
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