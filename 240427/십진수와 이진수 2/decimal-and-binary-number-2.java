import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] num = br.readLine().toCharArray();
        int ans = 0;
        int cnt = 0;
        int[] finalAns = new int[20];

        for(int i = 0; i<num.length; i++){
            ans  = ans * 2 + num[i] - '0';
        }

        ans *= 17;

        while(ans > 0){
            if(ans < 2){
                finalAns[cnt] = ans;
                break;
            }
            finalAns[cnt++] = ans % 2;
            ans /=2;
        }

        for(int i = cnt; i>=0; i--){
            sb.append(finalAns[i]);
        }
        System.out.print(sb.toString());
    }
}