import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        //numbers 초기화
        numbers = new int[n];
        for(int i = 0; i<n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        //연속 부분 수열 구하기
        int maxCnt = 0;
        int duplicateCnt = 0;
        for(int i = 0; i<n; i++){
            if(i == 0 || (numbers[i] < 0 && numbers[i-1] < 0) 
                ||  (numbers[i] > 0 && numbers[i-1] > 0)) { //numbers[i] * numbers[i-1] > 0 으로 작성해도됨 !!! 
                    duplicateCnt++;
            } else {
                duplicateCnt = 1;
            }
            maxCnt = Math.max(maxCnt, duplicateCnt);
        }
        System.out.print(maxCnt);
        
    }
}