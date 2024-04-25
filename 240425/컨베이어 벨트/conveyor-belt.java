import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,t;
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        


        //numbers 초기화
        numbers = new int[2][n];
        for(int i = 0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        //t번 회전
        for(int i = 0; i<t; i++){
            rotate();
        }

        //결과값 출력
        for(int i = 0; i<2; i++){
            for(int j = 0; j<n; j++){
                System.out.print(numbers[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void rotate(){
        int tmp1 = numbers[0][n-1];
        int tmp2 = numbers[1][n-1];

        //위 -> 오
        for(int i = n-1; i>0; i--){
            numbers[0][i] = numbers[0][i-1];
        }
        numbers[0][0] = tmp2;

        //아래 -> 오
        for(int i = n-1; i>0; i--){
            numbers[1][i] = numbers[1][i-1];
        }
        numbers[1][0] = tmp1;

    }
}