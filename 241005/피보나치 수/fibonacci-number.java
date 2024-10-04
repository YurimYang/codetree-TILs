import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        if(n<=2){
            System.out.println(1);
        } else {
            System.out.println(fibo(n));
        }
    }

    public static int fibo(int n){
        if(n <= 2){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}