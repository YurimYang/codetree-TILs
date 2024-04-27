import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //10진수
        int b = Integer.parseInt(st.nextToken()); //b진수로 변경
        int[] ans = new int[20];
        int cnt = 0;

        while(n > 0) {
            if(n < b){
                ans[cnt] = n;
                break;
            }
            ans[cnt++] = n%b;
            n/=b;
        }

        for(int dir = cnt; dir >=0; dir--){
            sb.append(ans[dir]);
        }

        System.out.print(sb.toString());


        
    }
}