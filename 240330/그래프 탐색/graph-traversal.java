import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringTokenizer st;
    static int n,m, ans = 0;
    public static final int MAX_NUM = 1000;
    static List<Integer>[] graph = new ArrayList[MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n개 정점
        m = Integer.parseInt(st.nextToken()); //m개 간선
        for(int i = 1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        int vertex = 1;
        visited[vertex] = true;
        dfs(vertex);
        System.out.println(ans);
    }

    //인접리스트
    public static void dfs(int vertex){
        for(int i = 0; i<graph[vertex].size(); i++){
            int currV = graph[vertex].get(i);
            if(!visited[currV]){
                visited[currV] = true;
                ans++;
                dfs(currV);
            }
        }
    }


}