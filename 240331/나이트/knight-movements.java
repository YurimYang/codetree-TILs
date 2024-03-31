import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, r1, r2, c1, c2;
    static int[][] step, visited;
    static Queue<Points> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1; //(r1,c1) -> (r2,c2)로 이동
        step = new int[n][n];
        visited = new int[n][n];

        visited[r1][c1] = 1;
        queue.add(new Points(r1,c1));
        bfs();

        System.out.println(step[r2][c2]);
    }

    public static void bfs(){
        int[] dx = new int[]{-1,-2,-2,-1,1,2,2,1};
        int[] dy = new int[]{-2,-1,1,2,2,1,-1,-2};

        while(!queue.isEmpty()){
            Points currPoint = queue.poll();
            int x = currPoint.x;
            int y = currPoint.y;

            if(x == r2 && y == c2){
                break;
            }

            for(int i = 0; i<8; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(canGo(newX, newY)){
                    step[newX][newY] = step[x][y] + 1;
                    visited[newX][newY] = 1;
                    queue.add(new Points(newX, newY));
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
        if(visited[x][y] == 1){
            return false;
        }
        return true;
    }

}

class Points{
    int x;
    int y;

    public Points(int x, int y){
        this.x = x;
        this.y = y;
    }
}