import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //n * m 크기의 이차원 영역

        //grid 초기화
        grid = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxSecondBlock = Math.max(secondBlockRow(), secondBlockCol());
        System.out.println(Math.max(firstBlock(), maxSecondBlock));
    }

    //1번 블럭의 경우 최대값
    public static int firstBlock(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n-1; i++){
            int sum = 0;
            for(int j = 0; j<m-1; j++){ //(i,j) 시작점
                max = Math.max(max,findMinimum(i,j));
            }
        }
        return max;
    }

    public static int findMinimum(int i, int j){
        int min = Integer.MAX_VALUE;
        int[] dx = new int[]{0,0,1,1};
        int[] dy = new int[]{0,1,0,1};
        int[] nums = new int[4];
        int maxSum = 0;
        for(int dir = 0; dir <4; dir++){
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            nums[dir] = grid[nx][ny];
        }
        Arrays.sort(nums);
        for(int z = 1; z<4; z++){
            maxSum += nums[z];
        }
        return maxSum;
    }

    //2번 블럭중 가로의 경우 최대값
    public static int secondBlockRow(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m-2; j++){
                int sum = 0;
                for(int k = j; k<=j+2; k++){
                    sum += grid[i][k];
                }
                max = Math.max(max, sum); 
            }
        }
        return max;
    }

    public static int secondBlockCol(){
        int max = Integer.MIN_VALUE;
        for(int j = 0; j<m; j++){
            for(int i = 0; i<n-2; i++){
                int sum = 0;
                for(int k = i; k<=i+2; k++){
                    sum += grid[k][j];
                }
                max = Math.max(max, sum); 
            }
        }
        return max;
    }
}