import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            return (o2.s + o2.e) - (o1.s + o1.e);
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            

        }
    }
}

class Meeting{
    int s;
    int e;

    public Meeting(int s, int e){
        this.s = s;
        this.e = e;
    }
}