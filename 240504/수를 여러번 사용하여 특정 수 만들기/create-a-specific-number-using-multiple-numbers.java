import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int maxSum = 0;
        for(int i = 0; i<1000; i++){
            int sum = 0;
            for(int j = 0; j<1000; j++){
                sum = a * i + b * j;
                if(sum <= c){
                    maxSum = Math.max(maxSum, sum);
                } else {
                    break;
                }
            }
        }
        System.out.print(maxSum);
    }

}