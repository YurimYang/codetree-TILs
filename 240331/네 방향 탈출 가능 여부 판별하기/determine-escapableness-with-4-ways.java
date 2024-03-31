import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] grid, visited;
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = 1;
        queue.add(new Pair(0,0));
        bfs();

        System.out.println(visited[n-1][m-1]);
    }

    public static void bfs(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            Pair currPair = queue.poll();
            int x = currPair.x;
            int y = currPair.y;

            for(int i = 0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(canGo(newX, newY)){
                    visited[newX][newY] = 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y < m;
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x,y)){
            return false;
        }
        if(grid[x][y] == 0 || visited[x][y] == 1){
            return false;
        }
        return true;
    }
}

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}