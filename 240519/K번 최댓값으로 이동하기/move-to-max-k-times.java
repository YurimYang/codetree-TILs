import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[][] grid, visited;
    static Queue<Point> queue = new LinkedList<>();
    static List<Point> startPointList = new ArrayList<>();
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // N*N 크기 격자, !~100 숫자 O
        k = Integer.parseInt(st.nextToken()); // 이동 횟수 K번, 작으면서 최대값 & 행, 열 가장 작은 번호로

        //grid 초기화
        grid = new int[n+1][n+1];
        for(int i = 1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<n+1; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작점 초기화
        visited = new int[n+1][n+1];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); 
        int y = Integer.parseInt(st.nextToken());
        Point startPoint = new Point(x, y, grid[x][y]);
        queue.add(startPoint);
        visited[x][y] = 1;
        startPointList.add(startPoint);

        for(int i = 0; i<k; i++){
            Point nextStartPoint = BFS();
            startPointList.add(nextStartPoint);
            queue.add(nextStartPoint);
            initial();
        }

        System.out.println(startPointList.get(k).x + " " + startPointList.get(k).y);
        

    }
    
    public static void initial(){
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<n+1; j++){
                visited[i][j] = 0;
            }
        }

        points = new ArrayList<>();
    }


    //visited를 위한 BFS
    public static Point BFS(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        int firstNum = queue.peek().num;

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            for(int i = 0; i<4; i++){
                int nx = currPoint.x + dx[i];
                int ny = currPoint.y + dy[i];
                

                if(canGo(nx, ny, firstNum)){
                    visited[nx][ny] = 1;
                    Point nextPoint = new Point(nx, ny, grid[nx][ny]);
                    //System.out.println("points : " + nextPoint.x + ", " + nextPoint.y + ", " + nextPoint.num);
                    queue.add(nextPoint);
                    points.add(nextPoint);
                }
            }
        }

        Collections.sort(points);
        return points.get(0);


    }

    public static boolean canGo(int x, int y, int firstNum){
        if(!inRange(x, y)){
            return false;
        } else if(grid[x][y] >= firstNum || visited[x][y] != 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x< n+1 && 1 <= y && y < n+1;
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;
    int num;

    public Point(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Point point) {
        if (this.num != point.num) {
            return Integer.compare(point.num, this.num); // num 기준 내림차순
        }
        if (this.x != point.x) {
            return Integer.compare(this.x, point.x); // x 기준 오름차순
        }
        return Integer.compare(this.y, point.y); // y 기준 오름차순
    }

}