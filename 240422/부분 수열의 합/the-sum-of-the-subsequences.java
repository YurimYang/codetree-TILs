import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n.m;
    static int[] num, dp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //num 배열 초기화
        st = new StringTokenizer(br.readLine());
        num = new int[n+1];
        for(int i = 1;i <n+1; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<i; j++){
                num[i] += 
                if(num[i] + num[j])
            }
        }

    }
}