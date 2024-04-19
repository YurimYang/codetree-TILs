import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] num;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //num 배열 초기화
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        //구간 잡아보기
        int ans = 0;
        for(int i = 0; i<n; i++){ 
            for(int j = i; j<n; j++){
                double avg = 0;
                for(int k = i; k<=j; k++){
                    avg += num[k];
                }
                avg /= ((j-i)+1);
                
                for(int z = i; z<=j; z++){
                    if(num[z] == avg){
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}