import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        //numbers 배열 초기화
        numbers = new int[n];
        for(int i = 0; i<n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        //동일한 숫자가 나오는 횟수 찾기
        int duplicateCnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(i == 0 || numbers[i] == numbers[i-1]){
                duplicateCnt++;
            } else {
                duplicateCnt = 1;
            }
            maxCnt = Math.max(maxCnt, duplicateCnt);
        }

        System.out.print(maxCnt);
    }
}