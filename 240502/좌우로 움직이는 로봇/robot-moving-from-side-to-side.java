import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] moveA, moveB;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //움직임 초기화
        moveA = new int[50000];
        moveB = new int[50000];
        int[] movedA = movement(moveA, n).move;
        int startA = movement(moveA, n).start;
        for(int i = 0; i<15; i++){
            System.out.println("A" + i + " : " + movedA[i]);
        }
        int[] movedB = movement(moveB, n).move;
        int startB = movement(moveB, n).start;

        for(int i = 0; i<15; i++){
            System.out.println("B" + i + " : " + movedB[i]);
        }

        System.out.println(countMeetCnt(movedA, movedB, Math.min(startA, startB)));  
    }

    public static tmp movement(int[] move, int times) throws IOException{
        int start = 1;
        for(int i = 0; i<times; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken(); //t초만큼 방향 d로 이동
            for(int j = start; j < start + t; j++){
                if(d.equals("L")){
                    move[j] = move[j-1] - 1;   
                }else if(d.equals("R")){
                    move[j] = move[j-1] + 1;                   
                }
            } 
            start += t;

        }
        return tmp(start, move);
    }

    public static int countMeetCnt(int[] moveA, int[] moveB, int len){
        int answer = 0; 
        for(int i = 1; i<len; i++){
            if(moveA[i] == moveB[i] && moveA[i-1] != moveB[i-1]){
                System.out.println(i +"," +moveA[i] +"," + moveB[i]);

                answer++;
            }
        }
        return answer;
    } 

}

class tmp{
    int times;
    int[] move;

    public tmp(int times, int[] move){
        this.times = times;
        this.move = move;
    }
}