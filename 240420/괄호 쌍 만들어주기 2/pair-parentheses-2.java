import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        int ans = 0;
        for(int i = 0; i<line.length()-1; i++){
            for(int j = i+1; j<line.length()-1; j++){
                if(line.charAt(i) == '(' && line.charAt(i+1) == '(' 
                && line.charAt(j) == ')' && line.charAt(j+1) == ')'){
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}