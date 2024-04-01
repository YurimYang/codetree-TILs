import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;

    public static void main(String args[]) throws IOException{
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        a = makeArray(a);
        b = makeArray(b);

        Arrays.sort(a);
        Arrays.sort(b);

        int tmp = 0;
        for(int i = 0; i<n ;i++){
            if(a[i] == b[i]){
                tmp++;
            }else{
                System.out.println("No");
                break;
            }
        }
        if(tmp == n){
            System.out.println("Yes");
        }

    }

    public static int[] makeArray(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}