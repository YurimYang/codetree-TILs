import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //num배열 초기화
        int[] num = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
            sum+= num[i];
        }
        int avg = sum / n;
        int ans = 0;
        for(int number : num){
            if(number>avg){
                ans += number - avg;
            }
        }

        System.out.print(ans);
    }
}