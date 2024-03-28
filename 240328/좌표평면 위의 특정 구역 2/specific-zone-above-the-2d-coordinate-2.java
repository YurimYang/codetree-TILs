import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y);
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                minX = Math.min(minX, pairs[j].x);
                minY = Math.min(minY, pairs[j].y);
                maxX = Math.max(maxX, pairs[j].x);
                maxY = Math.max(maxY, pairs[j].y);
            }
            sum = Math.min(sum, (maxX - minX) * (maxY - minY));
        }
        System.out.println(sum);
    }
}
class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y= y;
    }
}