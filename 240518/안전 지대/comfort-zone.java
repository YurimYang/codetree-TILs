import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] grid, visited;    

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //grid 초기화
        grid = new int[n][m];
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;
                maxNum = Math.max(maxNum, num); // K의 최대값
            }
        }

        //  System.out.println("maxNum: " + maxNum);

        //target 돌리기
        visited = new int[n][m];
        int maxAns = Integer.MIN_VALUE;
        int maxTarget = 0;
        for(int target = 1; target <= maxNum; target++){
            int answer = 0;
            initial();
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(visited[i][j] == 0 && grid[i][j] > target){
                        visited[i][j] = 1;
                        DFS(i, j, target);
                        answer++;
                    }
                }
            }
            // if(target > 60){
            // System.out.println("Target : " + target + " answer : " + answer);
            // }

            if(answer > maxAns){
                maxAns = answer;
                maxTarget = target;
            }
        }

        System.out.println(maxTarget + " " + maxAns);
    }

    public static void initial(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                visited[i][j] = 0;
            }
        }
    }

    public static void DFS(int x, int y, int k){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny, k)){
                visited[nx][ny] = 1;
                DFS(nx, ny, k);
            }
        }

    }

    public static boolean canGo(int x, int y, int k){
        if(!inRange(x,y)){
            return false;
        } else if(visited[x][y] != 0 || grid[x][y] <= k){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0<=x && x < n && 0<=y && y< m;
    }
}