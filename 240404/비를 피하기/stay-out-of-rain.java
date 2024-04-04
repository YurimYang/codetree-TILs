import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, h, m;
    static int[][] grid, visited, step;
    static List<Pair> personList = new ArrayList<>();
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        h = Integer.parseInt(st.nextToken()); //사람의 수
        m = Integer.parseInt(st.nextToken()); //비를 피할 수 있는 공간
        grid = new int[n][n];
        visited = new int[n][n];
        step = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 3){
                    personList.add(new Pair(i,j));
                }
            }
        }
        for(Pair person : personList){
            push(person.x, person.y, 0);
        }
        BFS();

        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] != 2){
                    System.out.print(0 + " ");
                } else {
                    if(visited[i][j] == 0){
                        System.out.print(-1 + " ");
                    }
                    else {
                        System.out.print(step[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }


    public static void push (int newX, int newY, int newStep){
        queue.add(new Pair(newX, newY));
        visited[newX][newY] = 1;
        step[newX][newY] = newStep;
    }

    public static void BFS(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            Pair currPair = queue.poll();
            int currX = currPair.x;
            int currY = currPair.y;

            for(int i = 0; i<4; i++){
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(canGo(newX, newY)){
                    push(newX, newY, step[currX][currY] + 1);
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0<=x & x<n && 0<=y && y<n;
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

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
/**
 * 0 : 해당 칸이 이동할 수 있는 곳
 * 1 : 벽이 있어 해당 칸이 이동할 수 없는 곳
 * 2 : 해당 칸에 사람이 서있음
 * 3 : 비를 피할 수 있는 공간
 * 최소시간 출력 = BFS
 */