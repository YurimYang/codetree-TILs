import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        
        // 끝나는 시간(e)을 기준으로 정렬하는 우선순위 큐 생성
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.e == o2.e) return o1.s - o2.s;
            return o1.e - o2.e;
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(s, e));
        }

        int time = 0;
        while(!pq.isEmpty()){
            Meeting next = pq.poll();
            if(next.s >= time){
                answer++;
                time = next.e;
            }
        }

        System.out.println(answer);


    }
}

class Meeting {
    int s;
    int e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }
}