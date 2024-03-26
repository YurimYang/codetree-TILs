import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[][] nums;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자 크기
        m = Integer.parseInt(st.nextToken()); //턴의 수
        nums = new int[n][n];
        dx = new int[]{-1,-1,-1,0,1,1,1,0};
        dy = new int[]{-1,0,1,1,1,0,-1,-1};

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(m-->0){
            simulate();
        }
        
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                sb.append(nums[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void simulate(){
        for(int i =1; i<=n*n; i++){
            Pairs pair = findPos(i);
            Pairs maxPair = moveToMax(pair);
            exchange(maxPair,pair);
        }
    }

    public static Pairs findPos(int num){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if (nums[i][j] == num) {
                    return new Pairs(i, j, nums[i][j]);
                }
            }
        }
        return new Pairs(0,0,0);
    }

    public static Pairs moveToMax(Pairs pair){
        Pairs maxPair = new Pairs(-1,-1,-1);
        for(int i = 0; i<8; i++){
            int nr = pair.r + dx[i];
            int nc = pair.c + dy[i];

            if(isInRage(nr,nc) && nums[nr][nc] > maxPair.num){
                maxPair.r = nr;
                maxPair.c = nc;
                maxPair.num = nums[nr][nc];
            }
        }
        return maxPair;
    }

    public static void exchange(Pairs maxPair, Pairs pair){
        int x = pair.r;
        int y = pair.c;

        int nx = maxPair.r;
        int ny = maxPair.c;

        int tmp = nums[x][y];
        nums[x][y] = nums[nx][ny];
        nums[nx][ny] = tmp;
    }

    public static boolean isInRage(int r, int c){
        if(0<=r && r <n && 0<=c && c<n){
            return true;
        }
        return false;
    }
}

class Pairs {

    int r;
    int c;
    int num;

    public Pairs(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}