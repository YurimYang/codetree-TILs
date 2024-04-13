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
            return memo[n]; //이미 계산 된 것은 더 계산하지 않도록 -1로 초기화 후에 계산됐다면 바로 return 하기 
        }
        if(n == 1 || n == 2){
            memo[n] = 1;
        } else {
            memo[n] = fibo(n-1) + fibo(n-2);    
        }
        return memo[n];
    }
}