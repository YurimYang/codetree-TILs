import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] a, b;

    public static void main(String args[]) throws IOException{
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        a = makeArray(a);
        b = makeArray(b);

        Arrays.sort(a);
        Arrays.sort(b);

        if(isEqual()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static int[] makeArray(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    
    public static boolean isEqual(){
        for(int i = 0; i<n ;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}