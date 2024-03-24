import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        char[] charArr = input.toCharArray();
        Arrays.sort(charArr);
        String answer = new String(charArr);
        System.out.println(answer);
    }
}