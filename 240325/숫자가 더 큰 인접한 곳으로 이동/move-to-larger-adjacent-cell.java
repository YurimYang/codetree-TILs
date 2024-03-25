import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, r, c;
    static int[][] nums;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        nums = new int[n + 1][n + 1];
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(nums[r][c] + " ");
        Pair targetPair = new Pair(r, c, nums[r][c]);
        boolean isTrue = true;

        while(isTrue){
            isTrue = false;
            for (int i = 0; i < 4; i++) {
                int xIdx = targetPair.x + dx[i];
                int yIdx = targetPair.y + dy[i];

                if (isInRange(xIdx,yIdx) && nums[xIdx][yIdx] > targetPair.num) {
                    targetPair.x = xIdx;
                    targetPair.y = yIdx;
                    targetPair.num = nums[xIdx][yIdx];
                    sb.append(targetPair.num + " ");
                    isTrue = true;
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean isInRange(int x, int y) {
        if (1 <= x && x <= n && 1 <= y && y <= n){
            return true;
        }
        return false;
    }
}

class Pair {
    int x;
    int y;
    int num;

    public Pair(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}