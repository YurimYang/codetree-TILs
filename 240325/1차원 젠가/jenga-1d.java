import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] blocks, tmp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        blocks = new int[n];
        for(int i = 0; i<n; i++){
            blocks[i] = Integer.parseInt(br.readLine());
        }
        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());

        makeZero(s1,e1);
        makeTmp();
        makeZero(s2,e2);
        makeTmp();

        System.out.println(blocks.length);
        for(int i = 0; i< blocks.length; i++){
            System.out.println(blocks[i]);
        }


    }

    public static void makeZero(int s, int e){
        for(int i = s - 1; i<e; i++){
            blocks[i] = 0;
        }
    }

    public static void makeTmp(){
        int endOfTmp = 0;
        tmp = new int[blocks.length];
        for(int i = 0; i<blocks.length;i++){
            if(blocks[i] == 0){
                continue;
            }
            tmp[endOfTmp] = blocks[i];
            endOfTmp++;
        }
        blocks = new int[endOfTmp];
        for(int i = 0; i<endOfTmp; i++){
            blocks[i] = tmp[i];
        }
    }
}