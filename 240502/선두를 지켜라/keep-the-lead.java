import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] moveA, moveB;
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //움직임 초기화
        moveA = new int[MAX];
        moveB = new int[MAX];
        int[] movedA = movement(n, moveA);
        int[] movedB = movement(m, moveB);

        //선두 여부 확인
        System.out.println(isFaster(movedA, movedB));
    }

    public static int[] movement(int times, int[] move) throws IOException{
        int start = 0;
        for(int i = 0; i<times; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = start; j<start + t; j++){
                int distance = v * j;
                move[j] = distance;
            }
            start += t;
        }
        return move;
    }

    public static int isFaster(int[] moveA, int[] moveB){
        int min = Math.min(moveA.length, moveB.length);
        String fastFirst;
        int answer = 0;
        if(moveA[0] > moveB[0]){
            fastFirst = "A";
        } else {
           fastFirst = "B";
        }
        
        for(int i = 0; i<min; i++){
            if(fastFirst.equals("A") && moveB[i] > moveA[i]){
                fastFirst = "B";
                answer++;
            } else if (fastFirst.equals("B") && moveB[i] < moveA[i]){
                fastFirst = "A";
                answer++;
            }
        }
        return answer;
    }
}