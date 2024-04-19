import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] charArr = br.readLine().toCharArray();
        boolean validate = false;
        for(char ch : charArr){
            if(ch == '0'){
                validate = true;
            } 
        }
        if(validate){
            isZero(charArr);
        } else {
            noZero(charArr);
        }
        
    }

    //n에 0이 있는 경우
    public static void isZero(char[] charArr){
        int ans = 0;
        for(int i = 0; i<charArr.length; i++){
            if(charArr[i] == '0'){
                charArr[i] = '1';
                break;
            }
        }
        for(int i = 0; i<charArr.length; i++){
            ans +=  (charArr[i] - '0') * Math.pow(2, charArr.length -1 -i);
        }
        System.out.print(ans);

    }

    

    //n에 0이 없는 경우
    public static void noZero(char[] charArr){
        charArr[charArr.length - 1] = '0';
        int ans = 0;
        for(int i = 0; i<charArr.length; i++){
            ans += (charArr[i] - '0') * Math.pow(2, charArr.length -1 -i);
        }
        System.out.print(ans);
    }
}