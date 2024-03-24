import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] intArr = new Integer[n];
        for(int i = 0; i<n; i++){
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        System.out.println(intArr[k-1]);
    }
}