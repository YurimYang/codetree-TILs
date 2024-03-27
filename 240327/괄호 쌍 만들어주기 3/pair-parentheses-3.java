import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] charArr;
    static int ans;

    public static void main(String[] args) throws IOException {
         charArr = br.readLine().toCharArray();
         for(int i = 0; i<charArr.length; i++){
             for(int j = i+1; j<charArr.length; j++){
                 if(charArr[i] == '(' && charArr[j] == ')'){
                     ans++;
                 }
             }

         }
        System.out.println(ans);
    }
}