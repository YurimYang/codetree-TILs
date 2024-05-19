import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] visited, step;
    static Queue<Point> queue = new LinkedList<>();
    static int n, answer = 0, r1, r2, c1, c2;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        visited = new int[n+1][n+1];
        step = new int[n+1][n+1];
        //r1, c1 (시작점)
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        visited[r1][c1] = 1;
        push(r1,c1,step[r1][c1]);
        BFS();
        
        //r2, c2 (종료점)
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());


        // for(int i = 0; i<n+1; i++){ 
        //     for(int j = 0; j<n+1; j++){
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        if(step[r2][c2] > 0 || visited[r2][c2] > 0){
            System.out.println(step[r2][c2]);
        } else{
            System.out.println(-1);
        }
 
    }

    
    public static void BFS(){
        int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();

            for(int i = 0; i<8; i++){
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
        } else if(visited[x][y] != 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 1<= x && x< n+1 & 1 <= y && y < n+1;
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