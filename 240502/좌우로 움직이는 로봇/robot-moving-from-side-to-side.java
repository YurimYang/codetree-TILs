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

        int startA = 1;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken(); //t초만큼 방향 d로 이동
            for(int j = startA; j < startA + t; j++){
                if(d.equals("L")){
                    moveA[j] = moveA[j-1] - 1;   
                }else if(d.equals("R")){
                    moveA[j] = moveA[j-1] + 1;                   
                }
            } 
            startA += t;
        }

        moveB = new int[50000]; 
        int startB = 1;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken(); //t초만큼 방향 d로 이동
            for(int j = startB; j < startB + t; j++){
                if(d.equals("L")){
                    moveB[j] = moveB[j-1] - 1;   
                }else if(d.equals("R")){
                    moveB[j] = moveB[j-1] + 1;                   
                }
            } 
            startB += t;
        }

        if(startA < startB) {
            for(int i = startA; i<startB; i++){
                moveA[i] = moveA[i-1];
            }
        } else {
            for(int i = startB; i<startA; i++){
                moveB[i] = moveB[i-1];
            }
        }
        System.out.println(countMeetCnt(moveA, moveB, Math.max(startA, startB)));  
    }

    public static int[] movement(int[] move, int times) throws IOException{
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
        return move;
    }

    public static int countMeetCnt(int[] moveA, int[] moveB, int len){
        int answer = 0; 
        for(int i = 2; i<len; i++){
            if(moveA[i] == moveB[i] && moveA[i-1] != moveB[i-1]){
                answer++;
            }
        }
        return answer;
    } 

}