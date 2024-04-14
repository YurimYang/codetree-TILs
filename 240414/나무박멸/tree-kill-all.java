import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k, c, killedTrees = 0;
    static int[][] grid, tmpExpand, killspot, lifeTime;
    static List<Tree> treeLocation = new ArrayList<>();
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int[] kdx = new int[]{-1,-1,1,1};
    static int[] kdy = new int[]{-1,1,1,-1};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자의 크기
        m = Integer.parseInt(st.nextToken()); //박멸이 진행되는 년수
        k = Integer.parseInt(st.nextToken()); //제초제의 확산범위
        c = Integer.parseInt(st.nextToken()); //제초제가 남아있는 년 수
        grid = new int[n][n];
        killspot = new int[n][n];
        lifeTime = new int[n][n];

        //나무 , 벽 세우기
        // 0 : 빈칸, -1 : 벽
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] > 0){
                    treeLocation.add(new Tree(i,j));
                }
            }
        }

        tree();
        System.out.println(killedTrees);
    }

    //m년 동안 총 박멸한 나무의 그루수
    public static void tree(){
        while(m-- > 0){
            growthTree();
            expandTree();
            deleteLifeTime();
            Tree finalKillLocation = findKillSpot();
            killTree(finalKillLocation);
        }
    }

    public static boolean inRange(int nx, int ny){
        return 0<= nx && nx < n && 0 <=ny && ny < n;
    }

    public static boolean canGo(int nx, int ny){
        if(!inRange(nx, ny)){
            return false;
        }
        if(grid[nx][ny] > 0 || grid[nx][ny] == -1 || lifeTime[nx][ny] > 0){
            return false;
        }
        return true;
    }

    public static boolean canKill(int kx, int ky){
        if(!inRange(kx, ky)){
            return false;
        }
        if(grid[kx][ky] == -1 || lifeTime[kx][ky] > 0){
            return false;
        }
        return true;
    }

    //나무의 성장 : 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장
    public static void growthTree(){
        for(int i = 0; i<treeLocation.size(); i++){
            Tree currTree = treeLocation.get(i);
            int x = currTree.x;
            int y = currTree.y;

            for(int dir = 0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(inRange(nx, ny)){
                    if(grid[nx][ny] > 0 && lifeTime[nx][ny] <= 0){
                        grid[x][y]++;
                    }
                }
            }
        }
    }

    //나무의 번식 : 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행
    public static void expandTree(){
        List<Tree> tmpTreeLocation = new ArrayList<>();
        tmpExpand = new int[n][n];
        for(int i = 0; i<treeLocation.size(); i++){
            int dirSize = 0;
            Tree currTree = treeLocation.get(i);
            int x = currTree.x;
            int y = currTree.y;

            for(int dir = 0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(canGo(nx, ny)){
                    dirSize++;
                }
            }

            for(int dir = 0; dir<4; dir++){
                int ex = x + dx[dir];
                int ey = y + dy[dir];
                if(canGo(ex, ey)){
                    tmpExpand[ex][ey] += grid[x][y] / dirSize;

                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(tmpExpand[i][j] > 0){
                    grid[i][j] += tmpExpand[i][j];
                    tmpTreeLocation.add(new Tree(i, j));
                }
            }
        }
        //새롭게 심어진 나무도 treeLocation list에 추가한다.
        for(Tree tmpTree : tmpTreeLocation){
            treeLocation.add(new Tree(tmpTree.x, tmpTree.y));
        }
    }

    //제초제 위치 선정 : 대각선으로 k 만큼씩 다 더해서 가장 큰 곳 선정
    public static Tree findKillSpot(){
        Tree killTreeLocation = new Tree(0,0);
        int maxDelTree = 0;
        for(int i = 0; i<treeLocation.size(); i++){
            Tree currTree = treeLocation.get(i);
            int x = currTree.x;
            int y = currTree.y;
            int countTree = grid[x][y];
            for(int dir = 0; dir<4; dir++){
                for(int ex = 1; ex<= k; ex++){
                    int kx = x + ex * kdx[dir];
                    int ky = y + ex * kdy[dir];
                    if(!inRange(kx, ky)){
                        break;
                    }
                    if(grid[kx][ky] <= 0){
                        break;
                    }
                    countTree += grid[kx][ky];
                }
            }
            if(maxDelTree < countTree){
                maxDelTree = countTree;
                killTreeLocation.x = x;
                killTreeLocation.y = y;
            }
        }

        killedTrees += maxDelTree;

        return killTreeLocation;
    }

    //제초제의 기간을 1년씩 감소
    public static void deleteLifeTime(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(lifeTime[i][j] > 0){
                    lifeTime[i][j]--;
                }
            }
        }
    }

    //제초제 뿌리는 작업 진행 : c년 만큼 제초제가 살아있음
    public static void killTree(Tree finalKillLocation){
        grid[finalKillLocation.x][finalKillLocation.y] = 0;
        lifeTime[finalKillLocation.x][finalKillLocation.y] = c;

        for(int dir = 0; dir<4; dir++){
            for(int ex = 1; ex<=k; ex++){
                int kx = finalKillLocation.x + ex * kdx[dir];
                int ky = finalKillLocation.y + ex * kdy[dir];
                if(!inRange(kx, ky)){
                    break;
                }
                if(grid[kx][ky] < 0){
                    break;
                }
                if(grid[kx][ky] == 0) {
                    lifeTime[kx][ky] = c;
                    break;
                }
                grid[kx][ky] = 0;
                lifeTime[kx][ky] = c;

            }
        }

        //제초제가 뿌려짐에 따라 tree 현 상황 다시 체크
        treeLocation.clear();
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] > 0 && lifeTime[i][j] <= 0){
                    treeLocation.add(new Tree(i,j));
                }
            }
        }
    }
}

class Tree{
    int x;
    int y;

    public Tree(int x, int y){
        this.x = x;
        this.y = y;
    }
}