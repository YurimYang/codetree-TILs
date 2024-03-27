import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int maxSum = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<= n-k; i++){
            int maxTmp = 0;
            for(int j = i; j<i+k; j++){
                maxTmp += nums[j];
            }
            maxSum = Math.max(maxSum, maxTmp);
        }
        System.out.println(maxSum);
    }
}