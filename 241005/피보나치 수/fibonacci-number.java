import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] fibo;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        fibo = new int[46];

        fibo[1] = 1;
        fibo[2] = 1;
        for(int i = 3; i<=n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[n]);
    }
}