import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, ans = 0;
    static int[][] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numbers[a][b] = 1;
            numbers[b][a] = 1;
        }

        int currV = 1;
        visited[currV] = true;
        dfs(currV);
        System.out.println(ans);
    }


    public static void dfs(int vertex){
        visited[vertex] = true;
        for(int col = 1; col <=n; col++){
            if(numbers[vertex][col] == 1 && !visited[col]){
                visited[vertex] = true;
                ans++; 
                dfs(col); 
            }
        }

    }
}