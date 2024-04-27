import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] twoPointNumber = new int[20];
        int cnt = 0;

        while(n > 0){
            if(n < 2){
                twoPointNumber[cnt] = n;
                break;
            }
            twoPointNumber[cnt++] = n % 2;
            n/=2;
        }

        for(int i = cnt; i>=0; i--){
            sb.append(twoPointNumber[i]);
        }
        System.out.print(sb.toString());
        
    }
}