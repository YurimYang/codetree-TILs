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
        System.out.print(findHowLongChanged(a,b,c));
    }

    public static int findHowLongChanged(int day, int hour, int min){
        int days = (day - 11) * 60 * 24;
        int times = Math.abs(findHowTimeChanged(11,11) - findHowTimeChanged(hour,min));
        return days + times;
    }

    public static int findHowTimeChanged(int hour, int min){
        return hour * 60 + min;
    }
}