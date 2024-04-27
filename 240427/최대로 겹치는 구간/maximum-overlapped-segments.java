import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int toPlus = 100;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[400];

        //겹치는 구간 찾기
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a += toPlus;
            b += toPlus;
            

            for(int j = a; j<b; j++){
                ans[j]++;
            }
        }

        //최대 겹치는 구간 찾기
        int answer = Integer.MIN_VALUE;
        for(int k = 0; k<=200; k++){
            answer = Math.max(answer, ans[k]);            
        }
        System.out.print(answer);
    }
}