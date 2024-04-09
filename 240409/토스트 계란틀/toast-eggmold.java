import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 50;
    
    public static int n, L, R;
    
    public static int[][] egg = new int[MAX_N][MAX_N];
    
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static ArrayList<Pair> eggGroup = new ArrayList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean canGo(int x, int y, int currEgg) {
        if(!inRange(x, y))
          return false;
          
        int eggDiff = Math.abs(egg[x][y] - currEgg);
        return !visited[x][y] 
            && L <= eggDiff && eggDiff <= R;
    }
    
    // visited 배열을 초기화 해줍니다.
    public static void initializeVisited() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                visited[i][j] = false;
    }
    
    public static void bfs() {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
    
        // BFS 탐색을 수행합니다.
        while(!bfsQ.isEmpty()) {
            Pair currPos = bfsQ.poll();
            int currX = currPos.x, currY = currPos.y;
    
            for(int i = 0; i < DIR_NUM; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
    
                // L, R 사이인 경우에만 합쳐질 수 있습니다.
                if(canGo(newX, newY, egg[currX][currY])) {
                    bfsQ.add(new Pair(newX, newY));
                    eggGroup.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    
    // 계란들을 합칩니다.
    public static void mergeEggs() {
        int sumOfEggs = 0;
        for(int k = 0; k < eggGroup.size(); k++) {
            int x = eggGroup.get(k).x, y = eggGroup.get(k).y;
            sumOfEggs += egg[x][y];
        }
    
        for(int k = 0; k < eggGroup.size(); k++) {
            int x = eggGroup.get(k).x, y = eggGroup.get(k).y;
            egg[x][y] = sumOfEggs / eggGroup.size();
        }    
    }
    
    // 조건에 맞게 계란의 양을 바꿔줍니다.
    public static boolean moveEggs() {
        // BFS 탐색을 위한 초기화 작업을 수행합니다.
        initializeVisited();
        
        boolean isChanged = false;
    
        // 아직 방문하지 못한 칸에 대해
        // BFS 탐색을 통해 합쳐질 계란들을 찾아냅니다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    // 합쳐질 계란 목록을 담을 곳을 초기화합니다.
                    eggGroup = new ArrayList<>();
                    
                    bfsQ.add(new Pair(i, j));
                    eggGroup.add(new Pair(i, j));
                    visited[i][j] = true;
    
                    bfs();
                    
                    // 계란의 이동이 한번이라도 일어났는지를 확인합니다.
                    if(eggGroup.size() > 1)
                        isChanged = true;
                    
                    // (i, j)와 관련이 있는 계란들을 합칩니다.
                    mergeEggs();
                }
            }
        }
        
        return isChanged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) 
                egg[i][j] = sc.nextInt();

        int moveCnt = 0;
        // 이동이 더 이상 필요 없을 때까지
        // 계란의 이동을 반복합니다.
        while(true) {
            boolean isChanged = moveEggs();
            if(!isChanged)
                break;
            
            moveCnt++;
        }
        
        System.out.print(moveCnt);
    }
}