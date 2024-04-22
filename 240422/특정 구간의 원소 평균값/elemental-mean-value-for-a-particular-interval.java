import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] num;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //num배열 초기화
        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //평균값 확인
        int answer = 0;
        for(int i = 0; i<n; i++){ //시작점
            for(int j = i; j<n; j++){ //끝점  
                int sum = 0;  
                double avg = 0;
                for(int k = i; k<=j; k++){
                    sum += num[k];
                }
                avg = sum / (j-i+1);
                for(int z = i; z<=j; z++){
                    if(sum % (j-i + 1) == 0 && (int) avg == num[z]){
                        answer++;
                        break;
                    }
                }
            } 
        }
        System.out.print(answer);
    }
}