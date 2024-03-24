import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] numArr = new Integer[input];
        for(int i = 0; i<input; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        for(Integer num : numArr){
            System.out.print(num + " ");
        }
        System.out.println("");
        Arrays.sort(numArr,Collections.reverseOrder());
        for(Integer num : numArr){
            System.out.print(num + " ");
        }
    }
}