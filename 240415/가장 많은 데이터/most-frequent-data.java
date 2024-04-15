import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String color = br.readLine();
            map.put(color, map.getOrDefault(color, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(Integer color : map.values()){
            max = Math.max(max, color);
        }

        System.out.print(max);
    }
}