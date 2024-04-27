import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] num = br.readLine().toCharArray();
        int ans = 0;

        for(int i = 0; i<num.length; i++){
            ans = ans * 2 + num[i] - '0';
        }

        System.out.print(ans);
    }
}