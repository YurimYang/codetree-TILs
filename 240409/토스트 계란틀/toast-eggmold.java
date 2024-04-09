import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, L, R;
    static int[][] grid, visited;
    static Queue<Point> sum = new LinkedList<>();
    static List<Point> group = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //이상
        R = Integer.parseInt(st.nextToken()); //이하
        grid = new int[n][n];
        visited = new int[n][n];
        int ans = 0;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(!move()){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static void mergeEggs(){
        int total = 0;
        for(Point point : group){
            total += grid[point.x][point.y];
        }
        for(Point point : group){
            grid[point.x][point.y] = total/group.size();
        }
    }

    public static void BFS(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!sum.isEmpty()){
            Point currPoint = sum.poll();
            int x = currPoint.x;
            int y = currPoint.y;
            
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny, grid[x][y])){
                    visited[nx][ny] = 1;
                    group.add(new Point(nx, ny));
                    sum.add(new Point(nx,ny));
                }
            }
        }
    }

    public static void initial(){
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                visited[i][j] = 0;
            }
        }
    }

    public static boolean move(){
        initial();
        boolean isChanged = false;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visited[i][j] == 0){
                    group = new ArrayList<>();
                    sum.add(new Point(i,j));
                    group.add(new Point(i,j));
                    visited[i][j] = 1;

                    BFS();

                    if(group.size() > 1){
                        isChanged = true;
                    }
                    mergeEggs();
                }
            }
        }
        return isChanged;
    }

    public static boolean canGo(int nx, int ny, int curr){
        if(!inRange(nx,ny)){
            return false;
        }
        int diff = Math.abs(grid[nx][ny] - curr);
        if(visited[nx][ny] == 1 || diff< L || diff > R){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y<n;
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