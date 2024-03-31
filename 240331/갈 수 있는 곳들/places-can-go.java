import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] grid, visited;
    static Queue<Pairs> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        int k = Integer.parseInt(st.nextToken()); //시작점의 수
        grid = new int[n][n];
        visited = new int[n][n];
        int ans = 0;

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int z = 0; z<k; z++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queue.add(new Pairs(x,y));
            visited[x][y] = 1;
            bfs();
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                ans += visited[i][j];
            }
        }
        System.out.println(ans);
    }

    public static void bfs(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            Pairs currPair = queue.poll();
            int x = currPair.x;
            int y = currPair.y;

            for(int i = 0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(canGo(newX, newY)){
                    visited[newX][newY] = 1;
                    queue.add(new Pairs(newX, newY));
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0 <= x && x<n && 0 <= y && y <n;
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x,y)){
            return false;
        }
        if(grid[x][y] == 1 || visited[x][y] == 1){
            return false;
        }
        return true;
    }
}

class Pairs{
    int x;
    int y;

    public Pairs(int x, int y){
        this.x = x;
        this.y = y;
    }
}