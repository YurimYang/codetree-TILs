import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] stair;
    //한번에 2계단, 3계단 
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        stair = new int[n+1];
        System.out.println(stairs(n) % 10007);
    }

    public static int stairs(int n){
        if(stair[n] != 0){
            return stair[n];
        }
        if(n == 2 || n == 3){
            stair[n] = 1;
        } else {
            stair[n] = stairs(n-2) + stairs(n-3);
        }
        return stair[n];
    }
}