import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, order = 1;;
    static int[][] grid, visited, answer;
    

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new int[n][m];
        answer = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = 1;
        answer[0][0] = order;
        DFS(0,0);
        
        if(answer[n-1][m-1] > 0){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
   
    }

    public static void DFS(int x, int y){
        int[] dx = new int[]{1,0};
        int[] dy = new int[]{0,1};

        for(int i = 0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)){
                answer[nx][ny] = order++;
                visited[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x,y)){
            return false;
        } else if (visited[x][y] != 0 || grid[x][y] == 0){
            return false;
        } 
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y< m;
    }
}