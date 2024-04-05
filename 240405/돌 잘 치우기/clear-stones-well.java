import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, m, r, c, max;
    static int[][] grid, visited;
    static List<Pos> startList = new ArrayList<>();
    static List<Pos> stoneList = new ArrayList<>();
    static List<Pos> selectedStonesList = new ArrayList<>();
    static Queue<Pos> queue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자크기
        k = Integer.parseInt(st.nextToken()); //시작점의 수
        m = Integer.parseInt(st.nextToken()); //꼭 치워야할 돌
        max = Integer.MIN_VALUE;
        grid = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > 0) {
                    stoneList.add(new Pos(i, j));
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            startList.add(new Pos(r,c));
        }
        pickStone(0, 0);

        System.out.println(max);
    }

    public static void pickStone(int idx, int cnt) {
        if (idx == stoneList.size()) {
            if (cnt == m) {
                max = Math.max(max, calc());
            }
            return;
        }
        selectedStonesList.add(stoneList.get(idx));
        pickStone(idx + 1, cnt + 1);
        selectedStonesList.remove(selectedStonesList.size() - 1);
        pickStone(idx + 1, cnt);
    }

    public static void initialized() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
    }

    public static int calc() {
        for (int i = 0; i < m; i++) {
            grid[selectedStonesList.get(i).x][selectedStonesList.get(i).y] = 0;
        }
        initialized();
        for(Pos start : startList){
            queue.add(start);
        }
        BFS();
        for (int i = 0; i < m; i++) {
            grid[selectedStonesList.get(i).x][selectedStonesList.get(i).y] = 1;
        }
        return sumOfVisited();
    }


    public static void BFS() {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pos currPos = queue.poll();
            int x = currPos.x;
            int y = currPos.y;
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    queue.add(new Pos(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    public static int sumOfVisited() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public static boolean inRange(int x, int y) {
        return 0 <= x & x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }
        if (grid[x][y] == 1 || visited[x][y] == 1) {
            return false;
        }
        return true;
    }

}

class Pos {

    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//0 : 이동 o
//1 : 이동 x