import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] people = new int[n+1];
        for(int i = 1; i<=n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i<=n; i++){
            int distance = 0;
            for(int j = 1; j<=n; j++){
                distance += people[j] * Math.abs(j-i);
            }
            if(distance < min){
                min = distance;
            }
        }
        System.out.println(min);
    }
}