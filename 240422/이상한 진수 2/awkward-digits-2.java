import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] number = br.readLine().toCharArray();

        //0 여부 확인
        String changedNumber = null;
        for(int i = 0; i<number.length; i++){
            if(number[i] == '0'){
                changedNumber = haveZero(number);
                break;
            } else if (i == number.length - 1) {
                changedNumber = haveNotZero(number);
            }
        }
        
        //2진수 -> 10진수
        int ans = 0;
        for(int i = 0; i<changedNumber.length(); i++){
            ans += Math.pow(2, changedNumber.length() - i - 1) * Integer.parseInt(String.valueOf(changedNumber.charAt(i)));
        }

        //2진수 -> 10진수 (해답코드)
        int num = 0;
        for(int i = 0; i<changedNumber.length(); i++){
            num = num * 2 + (changedNumber.charAt(i) - '0');
        }

        System.out.print(ans);
    }

    //0이 있을 경우
    public static String haveZero(char[] number){
        for(int i = 0; i<number.length; i++){
            if(number[i] == '0'){
                number[i] = '1';
                break;
            }
        }
        return String.valueOf(number);
    }

    //0이 없을 경우
    public static String haveNotZero(char[] number){
        number[number.length - 1] = '0';
        return String.valueOf(number);
    }
}