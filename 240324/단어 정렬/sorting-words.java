import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        for(int i = 0; i<n; i++){
            strArr[i] = br.readLine();
        }
        Arrays.sort(strArr);
        for(int i = 0; i<n;i++){
            System.out.println(strArr[i]);
        }
    }
}