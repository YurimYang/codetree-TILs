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
    static List<Point> people = new ArrayList<>();
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
                } else if(grid[i][j] == 1){
                    people.add(new Point(i,j));
                }  
            }
        }
        findM_hospital(0,-1);
        System.out.println(ans);
    }

    public static int getDistance(Point people, Point hospital){
        return Math.abs(people.x - hospital.x) + Math.abs(people.y - hospital.y);
    }

    public static int getCurrMinDistance() {
        int distance = 0;

        for(int i = 0; i<people.size(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<hospital.size(); j++){
                if(hospitalVisit[j]){
                    min = Math.min(min, getDistance(people.get(i), hospital.get(j)));
                }
            }
            distance += min;
        }
        return distance;
    }


    public static void findM_hospital(int cnt, int latIdx){
        if(cnt == m){
            ans = Math.min(ans, getCurrMinDistance());
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