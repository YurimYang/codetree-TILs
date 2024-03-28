import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int maxSum = Integer.MIN_VALUE;
        for(int i = x; i<=y; i++){
            char[] chars =  String.valueOf(i).toCharArray();
            int sum = 0;
            for(char ch : chars){
                sum += ch - '0';
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}