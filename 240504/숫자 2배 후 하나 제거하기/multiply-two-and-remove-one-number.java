import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] numbers, checking, newArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        //numbers 초기화
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //2배 완전탐색 진행
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            numbers[i] *= 2;

            newArr = new int[n-1];
            for(int k = 0; k<n; k++){
                int cnt = 0;
                for(int m = 0; m<n; m++){
                    if(k != m){
                        newArr[cnt++] = numbers[m];
                    }  
                }
                int sum = 0;
                for(int j = 0; j<n-2; j++){
                    sum += Math.abs(newArr[j] - newArr[j+1]);
                    
                }
                minSum = Math.min(minSum, sum); 
            }
            numbers[i] /= 2;
        }
        System.out.print(minSum);
    }
}