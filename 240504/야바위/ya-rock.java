import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] cups;
    static List<change> cupList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cupList.add(new change(a,b,c));

        }

        cups = new int[4];
        int finalAnswer = 0;
        for(int target = 1; target<4; target++){
            int answer = 0;
            for(change cup : cupList){
                cups[cup.y] = cup.x;
                cups[cup.x] = cup.y;
                if(cups[cup.open] == target){
                    answer++;
                }
            }
            finalAnswer = Math.max(finalAnswer, answer);
        }

        System.out.print(finalAnswer);

        
    }
}

class change{
    int x;
    int y;
    int open;

    public change(int x, int y, int open){
        this.x = x;
        this.y = y;
        this.open = open;
    }
}