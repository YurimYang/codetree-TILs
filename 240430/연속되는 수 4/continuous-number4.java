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
        int numberGrwoth = 0;
        for(int i = 0; i<n; i++){
            if(i == 0 || numbers[i] > numbers[i-1]){
                numberGrwoth++;
            } else if (numbers[i] == numbers[i-1]){
                continue;
            } else {
                numberGrwoth = 1;
            }
        }
        System.out.print(numberGrwoth); 
    }
}