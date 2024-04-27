import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    static String[] dayOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int firstChange = howLongMDChanged(m1,d1);
        int secChange = howLongMDChanged(m2,d2);


        int diff = secChange - firstChange;
        while(diff<0){
            diff += 7;
        }
        System.out.print(dayOfWeek[diff % 7]); 
    }

    public static int howLongMDChanged(int month, int day){
        int days = 0;
        for(int i = 0; i<month; i++){
            days += dayOfMonth[i];
        }
        days += day;
        return days;
    }


}