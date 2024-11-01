import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //동전의 종류
        int k = Integer.parseInt(st.nextToken()); //금액

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            return o2 - o1;
        });
        for(int i = 0; i<n; i++){
            int money = Integer.parseInt(br.readLine());
            pq.offer(money);
        }

        int answer = 0;
        while(!pq.isEmpty()){
            int curr = pq.poll();

            if(curr > k) {
                break;
            }
            int cnt = 0;
            cnt += k / curr;
            k -= cnt * curr;
            answer += cnt;
        }
        System.out.println(answer);
    }
}