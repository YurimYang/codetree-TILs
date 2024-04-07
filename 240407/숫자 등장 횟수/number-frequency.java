import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());
            if(hm.containsKey(key)){
                System.out.print(hm.get(key) + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}