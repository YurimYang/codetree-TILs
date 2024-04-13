import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] memo;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        System.out.println(fibo(n));   
    }

    public static int fibo(int n){
        if(memo[n] != 0){
            return memo[n];
        }
        if(n == 1 || n == 2){
            memo[n] = 1;
        } else {
            memo[n] = fibo(n-1) + fibo(n-2);    
        }
        return memo[n];
    }
}