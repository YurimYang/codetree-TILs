import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Handshake[] situation;
    static int[] limit;
    static int[] isAddicted;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //n명의 개발자
        int K = Integer.parseInt(st.nextToken()); //k번의 악수동안 전염병 옮김
        int P = Integer.parseInt(st.nextToken()); //처음 전염병에 걸린 개발자 번호
        int T = Integer.parseInt(st.nextToken()); //t번에 걸쳐 악수 진행

        
       

        //상황 초기화
        situation = new Handshake[251]; 
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            situation[t] = new Handshake(x,y);
        }


        //k번의 악수동안 전염병 확인
        isAddicted = new int[N+1];
        limit = new int[N+1];
        isAddicted[P] = 1;
        for(int j = 0; j<251; j++){
            if(situation[j] != null){
                for(int z = 1; z<N+1; z++){
                    if(isAddicted[z] == 1 && situation[j].x == z  && limit[z] < K){
                        limit[z]++;
                        //limit[situation[j].y]++;
                        isAddicted[situation[j].y] = 1;
                        // System.out.println("first limit" + "z : " + z + "j: "+  j);
                        // print(limit);
                        // System.out.println("first : isAddicted");
                        // print(isAddicted);
                        break;
                    } else if(isAddicted[z] == 1 && situation[j].y == z  && limit[z] < K){
                        limit[z]++;
                        //limit[situation[j].x]++;
                        isAddicted[situation[j].x] = 1;
                        // System.out.println("second limit");
                        // print(limit);
                        // System.out.println("Second : isAddicted");
                        // print(isAddicted);
                        break;
                    }  
                }
            }
        }

        for(int i = 1; i<N+1; i++){
            sb.append(isAddicted[i]);
        }
        System.out.print(sb.toString());
        
    }

    public static void print(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(i + ": " + arr[i]);
        }
        
    }
}

class Handshake{
    int x;
    int y;

    public Handshake(int x, int y){
        this.x = x;
        this.y =y;
    }
}