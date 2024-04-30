import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] movementA;
    static int[] movementB;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // a 움직임 횟수
        int m = Integer.parseInt(st.nextToken()); // b 움직임 횟수

        //배열 초기화
        movementA = new int[1000000];
        movementB = new int[1000000]; //1,000 * 1,000 

        //움직임 기록
        int[] movedA = getMovement(movementA, n);
        int[] movedB = getMovement(movementB, m);

        // for(int i = 0; i<movedA.length; i++){
        //     System.out.print(movedA[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i<movedB.length; i++){
        //     System.out.print(movedB[i] + " ");
        // }

        //a,b 기록 확인
        System.out.print(samePlace(movedA, movedB));
    }

    public static int[] getMovement(int[] movement, int cnt) throws IOException{
        int start = 1;
        int now = 0;
        for(int i = 0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            if(dir.equals("R")) {
                for(int j = start; j<start + distance; j++){
                    now++;
                    movement[j] = now;
                }
            } else if (dir.equals("L")) {
                for(int k = start; k<start + distance ; k++){
                    now--;
                    movement[k] = now;
                }
            }
            start += distance;
        }
        return movement;
    }

    public static int samePlace(int[] movedA, int[] movedB){
        int minLength = Math.min(movedA.length, movedB.length);
        for(int i = 1; i<minLength; i++){
            if((movedA[i] == movedB[i]) && movedA[i] != 0 && movedB[i] != 0){
                return i;
            }
        }
        return -1;
    }
}