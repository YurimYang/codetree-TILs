import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());

            int s = 0;
            int e = n-1;
            int minIdx = n;

            boolean isChanged = false;


            while (s<=e){
                int mid = (s+e) / 2;

                if(numArr[mid] >= target){
                    e = mid - 1;
                    if(numArr[mid] == target){
                        minIdx = Math.min(minIdx, mid);
                        isChanged = true;
                    }

                } else {
                    s = mid + 1;
                }
            }

            if(isChanged){
                System.out.println(minIdx + 1);
            } else {
                System.out.println(-1);
            }
        } 
    }
}