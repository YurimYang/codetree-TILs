import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static double[] stair;
    //한번에 2계단, 3계단 
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        stair = new double[1001];
        System.out.println((int) (stairs(n)));
    }

    public static double stairs(int n){
        if(stair[n] != 0){
            return stair[n];
        }
        if(n == 0 || n == 2 || n == 3){
            stair[n] = 1;
        } else if(n == 1){
            stair[n] = 0;
        } else if (n > 3) {
            stair[n] = (stairs(n-2) + stairs(n-3)) % 10007;
        }
        return stair[n];
    }
}