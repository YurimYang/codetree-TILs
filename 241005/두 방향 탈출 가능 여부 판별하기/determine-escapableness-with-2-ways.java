import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m, answer = 0;
    static int[][] graph;
    static int[][] visited;

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

        dfs(0,0);
        System.out.println(answer);

    }

    public static void dfs(int x, int y){
        int[] dx = {-1, 0}; //하 우
        int[] dy = {0, 1};


        if(x == n -1 && y == m - 1){
            if(visited[x][y] == 1){
                answer = 1;
                return;
            }
        }

        for(int i = 0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)){
                visited[nx][ny] = 1;
                dfs(nx, ny);
                visited[nx][ny] = 0;
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)){
            return false;
        }
        if(visited[x][y] != 0 || graph[x][y] == 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x < n && 0 <= y && y<m;
    }
}