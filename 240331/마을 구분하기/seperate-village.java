import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, ans = 1;
    static int[][] grid, visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(pointCondition(i,j)){
                    visited[i][j] = 1;
                    DFS(i,j);
                    answer.add(ans);
                    ans = 1;
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for(int num : answer){
            System.out.println(num);
        }
    }

    public static void DFS(int x, int y){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1}; //상하좌우

        for(int i = 0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(canGo(newX,newY)){
                visited[newX][newY] = 1;
                ans++;
                DFS(newX,newY);
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y<n;
    }

    public static boolean pointCondition(int x, int y){
        if(grid[x][y] == 0 || visited[x][y] == 1){
            return false;
        }
        return true;
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x,y)){
            return false;
        }
        if(!pointCondition(x,y)){
            return false;
        }
        return true;
    }
}