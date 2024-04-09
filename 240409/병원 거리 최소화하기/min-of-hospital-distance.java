import java.util.*;
import java.io.*;
//남은 m개의 병원에 대한 각 사람들의 병원 거리의 총 합이 최소 
//사람 : 1
//병원 : 2
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[][] grid, visited, step;
    static List<Point> hospital = new ArrayList<>();
    static Queue<Point> pickedHospital = new LinkedList<>();
    static boolean[] hospitalVisit = new boolean[13];
    

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n*n 격자
        m = Integer.parseInt(st.nextToken()); //m개의 병원만을 남겨두기
        grid = new int[n][n];
        visited = new int[n][n];
        step = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 2){
                    hospital.add(new Point(i,j));
                }
            }
        }
        findM_hospital(0,-1);
        System.out.println(ans);
    }

    public static void initial(){
        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<n; j++){
                step[i][j] = 0;
                visited[i][j] = 0;
            }
        }
    }

    public static void findPickedHospital(){
        pickedHospital = new LinkedList<>();
        for(int i = 0; i< hospital.size(); i++){
            if(hospitalVisit[i]){
                pickedHospital.add(hospital.get(i));
            }
        }
    }

    public static int checkDistance(){
        int total = 0;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        initial();
        findPickedHospital();

        while(!pickedHospital.isEmpty()){
            Point currHospital = pickedHospital.poll();
            int x = currHospital.x; 
            int y = currHospital.y;
            visited[x][y] = 1;

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx,ny)){
                    pickedHospital.add(new Point(nx, ny));
                    step[nx][ny] = step[x][y] + 1;
                    visited[nx][ny] = 1;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    total += step[i][j];
                }
            }
        }
        return total;
    }

    public static boolean inRange(int x, int y){
        return 0<= x && x <n && 0<=y && y< n;
    }

    public static boolean canGo(int x, int y){
        if(!inRange(x,y)){
            return false;
        }
        if(visited[x][y] == 1 || grid[x][y] == 2){
            return false;
        }
        return true;
    } 


    public static void findM_hospital(int cnt, int latIdx){
        if(cnt == m){
            ans = Math.min(ans, checkDistance());
            return;
        }
        for(int i = latIdx + 1; i < hospital.size(); i++){
            hospitalVisit[i] = true;
            findM_hospital(cnt+1, i);
            hospitalVisit[i] = false;
        }
    }

}
class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}