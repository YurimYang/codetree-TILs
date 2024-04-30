import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] person, calls;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //사람 초기화
        person = new int[n+1];

        //호출번호 기록
        int answer = -1;
        boolean isStop = false;
        for(int i = 0; i<m; i++){
            int number = Integer.parseInt(br.readLine());
            person[number]++;
            for(int j = 1; j<n+1; j++){
                if(person[j] >= k){
                    answer = j;
                    isStop = true;
                    break;
                }
            }  
            if(isStop){
                break;
            }
        }
        System.out.print(answer);  
    }
}