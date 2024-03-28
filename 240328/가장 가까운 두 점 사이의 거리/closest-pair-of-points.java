import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Pairs[] pairArr = new Pairs[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairArr[i] = new Pairs(x, y);
        }

        int minPow = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                minPow = (int) Math.min(minPow, (Math.pow(pairArr[i].x - pairArr[j].x, 2) + Math.pow(
                    pairArr[i].y - pairArr[j].y, 2)));
            }
        }
        System.out.println(minPow);

    }
}

class Pairs {

    int x;
    int y;

    public Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}