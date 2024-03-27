import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] cows = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 1; i<=n; i++){
            for(int j = i; j<=n; j++){
                if(cows[j] > cows[i]){
                    for(int k = j; k<=n; k++){
                        if(cows[k] > cows[j]){
                            ans++;
                        }
                    }
                }

            }
        }
        System.out.println(ans);
    }
}