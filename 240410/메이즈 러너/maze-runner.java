import java.util.*;
import java.io.*;

//모든 참가자들의 이동 거리의 합
// 출구 좌표 

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k, ans = 0;
    static int[][] grid;
    static Pair exit;
    static HashMap<Integer, Pair> peoplePosition = new HashMap<>();;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //미로의 크기
        m = Integer.parseInt(st.nextToken()); //참가자수
        k = Integer.parseInt(st.nextToken()); //게임시간 == 회전수

        grid = new int[n+1][n+1];

        //벽 추가
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }

        //사람 추가
        for(int k = 0; k<m; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            peoplePosition.put(k+1, new Pair(x,y));
            grid[x][y] = -1;
        }

        //출구 추가
        st = new StringTokenizer(br.readLine());
        int outX = Integer.parseInt(st.nextToken());
        int outY = Integer.parseInt(st.nextToken());
        exit = new Pair(outX, outY);
        grid[outX][outY] = -2;
    }

    public static void move(){
        while(k-- > 0){
            peopleMove();
            clockwiseRotation();
        }
    }

    //최소 1명 포함 가장작은 정사각형 > r좌표 작은 것 > c좌표 작은 것
    public static void findSection(){
        f
    }

    public static void clockwiseRotation(){
        //회전해야하는 구간 구하기


        //회전하기

        //grid > 0인 공간 -1하기

        //
    }

    public static void peopleMove(){
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        for(int idx : peoplePosition.keySet()){
            Pair currPerson = peoplePosition.get(idx);
            int x = currPerson.x;
            int y = currPerson.y;
            if(x == -1 && y == -1){
                continue;
            }
            int distance = Math.abs(exit.x - x) + Math.abs(exit.y - y);

            List<Integer> movedDir = new ArrayList<>();
            int finalMovedDir = 0;

            for(int dir = 0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(canGo(nx, ny, distance)){
                    movedDir.add(dir);
                }
            }
            if(movedDir.size() > 0){
                grid[x][y] = 0;
                finalMovedDir = movedDir.get(0);
                int movedX = x+dx[finalMovedDir];
                int movedY = y+dy[finalMovedDir];
                //옮겼을 때, exit에 도달한 경우
                if(movedX == exit.x && movedY == exit.y){
                    peoplePosition.put(idx, new Pair(-1,-1));
                }else{
                    peoplePosition.put(idx, new Pair(movedX, movedY));
                    grid[movedX][movedY] = -1;
                }
                ans++;
            } 
        }
    }

    public static boolean inRange(int nx, int ny){
        return 1<=nx && nx<= n+1 && 1<=ny && ny<=n+1;
    }

    public static boolean calNewDistance(int nx, int ny, int distance){
        int newDistance = Math.abs(exit.x - nx) + Math.abs(exit.y - ny);
        if(newDistance == 0){
            return true;
        }
        if(newDistance > distance){
            return false;
        }
        return true;
    }

    public static boolean canGo(int nx, int ny, int distance){
        if(!inRange(nx,ny)){
            return false;
        } 
        if(grid[nx][ny] > 0){
            return false;
        }
        if(!calNewDistance(nx, ny, distance)){
            return false;
        }
        return true;
    }
}

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}