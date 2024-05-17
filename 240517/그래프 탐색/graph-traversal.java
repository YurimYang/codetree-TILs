import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] visited;
    static int n, m, ans = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int currV = 1;
        visited[currV] = true;
        dfs(currV);
        System.out.println(ans);   
    }

    public static void dfs(int vertex){
        for(int col = 1; col<=n; col++){
            if(graph[vertex][col] == 1 && !visited[col]){
                visited[col] = true;
                ans++;
                dfs(col);
            }
        }
    }
}