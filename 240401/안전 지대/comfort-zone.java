import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[][] grid, visited;

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];
        int maxCnt = Integer.MIN_VALUE;
        int tmp = 0;
        int answer = Integer.MIN_VALUE;
        int answerK = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxCnt = Math.max(maxCnt, grid[i][j]);
            }
        }

        for(int k = 1; k <= maxCnt; k++){
            initialized();
            tmp = checkSafety(k);

            if(tmp > answer){
                answer = tmp;
                answerK = k;
            }
        }

        System.out.print(answerK + " " + answer);
    }

    public static int checkSafety(int k){
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(canGo(i,j,k)){
                    visited[i][j] = 1;
                    DFS(i,j,k);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void initialized(){
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                visited[i][j] = 0;
            }
        }
    }

    public static void DFS(int x, int y, int k) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(canGo(newX, newY, k)){
                visited[newX][newY] = 1;
                DFS(newX, newY, k);
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0<=x & x<n && 0<=y && y<m;
    }

    public static boolean canGo(int x, int y, int k){
        if(!inRange(x,y)){
            return false;
        }
        if(grid[x][y] <= k || visited[x][y] == 1){
            return false;
        }
        return true;
    }

}