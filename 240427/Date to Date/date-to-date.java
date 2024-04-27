import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dayOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int answer = Math.abs(findChangedDays(m1,d1) - findChangedDays(m2,d2)) + 1;
        System.out.print(answer);
    }

    public static int findChangedDays(int m, int d){
        int days = 0;
        for(int i = 1; i<m; i++){
            days += dayOfMonth[i];
        }
        days += d;
        return days;
    }
}