import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int answer = Math.abs(findTimeChanged(a,b) - findTimeChanged(c,d));
        System.out.print(answer);
    }

    public static int findTimeChanged(int hour, int min){
        return hour * 60 + min;
    }
}