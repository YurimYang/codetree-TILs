import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] square = new int[1001];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(squares(n));

    }

    public static int squares(int n){

        if(square[n] != 0){
            return square[n];
        }

        if(n == 1){
            square[n] = 1;
        } else if (n == 2){
            square[n] = 2;
        } else {
            square[n] = (squares(n-1) + squares(n-2)) % 10007;    
        }

        return square[n];
        
    }
}