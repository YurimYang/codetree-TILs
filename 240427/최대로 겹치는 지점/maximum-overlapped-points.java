import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[101];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int s = x; s<=y; s++){
                ans[s]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int j = 0; j<ans.length; j++){
            max = Math.max(max, ans[j]);
        }
        System.out.print(max);
        
    }
}