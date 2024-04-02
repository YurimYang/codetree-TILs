import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, r, c;
    static int[][] grid, visited;
    static List<Integer> targetList = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자크기
        k = Integer.parseInt(st.nextToken()); //k번 반복
        grid = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1; //시작위치 행
        c = Integer.parseInt(st.nextToken())-1; //시작위치 열
        queue.add(new Point(r,c, grid[r][c]));
        targetList.add(grid[r][c]);

        for(int i = 0; i<targetList.size(); i++){
            BFS(targetList.get(i));
            initialized();
            if(i == k-1){
                int x = queue.peek().x + 1;
                int y = queue.peek().y + 1;
                System.out.println(x + " " + y);
                break;
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x< n && 0<=y && y<n;
    }

    public static boolean canGo(int x, int y, int num){
        if(!inRange(x,y)){
            return false;
        }
        if(visited[x][y] == 1 || grid[x][y] >= num){
            return false;
        }
        return true;
    }

    public static void initialized(){
        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                visited[i][j] = 0;
            }
        }
    }
    
    public static void BFS(int target){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        Point tmp = new Point(0,0,0);
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Point currPoint = queue.poll();
            int x = currPoint.x;
            int y = currPoint.y;
            visited[x][y] = 1;

            for(int i = 0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(canGo(newX, newY, target)){
                    visited[newX][newY] = 1;
                    Point newPoint = new Point(newX, newY, grid[newX][newY]);
                    queue.add(newPoint);
                    if(newPoint.num > max){
                        max = newPoint.num;
                        tmp = newPoint;
                    } else if (newPoint.num == tmp.num){
                        if(newPoint.x < tmp.x){
                            tmp = newPoint;
                        } else if(newPoint.x == tmp.x){
                            if(newPoint.y < tmp.y){
                                tmp = newPoint;
                            }
                        }
                    }
                }
            }
        }
        queue.add(tmp);
        targetList.add(tmp.num);
    }
}

class Point{
    int x;
    int y;
    int num;

    public Point(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}