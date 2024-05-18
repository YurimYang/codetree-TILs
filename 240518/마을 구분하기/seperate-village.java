import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n , count;
    static int[][] grid, visited;
    static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        //grid 초기화
        grid = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작점 돌기
        visited = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    visited[i][j] = 1;
                    count = 1;
                    DFS(i,j);
                    answerList.add(count);
                }
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.size());
        for(int i = 0; i<answerList.size(); i++){
            System.out.println(answerList.get(i));
        }
    }

    public static void DFS(int x, int y){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)){
                visited[nx][ny] = 1;
                count++;
                DFS(nx, ny);
            }
        }
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x, y)){
            return false; 
        } else if (visited[x][y] != 0 || grid[x][y] == 0){
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}