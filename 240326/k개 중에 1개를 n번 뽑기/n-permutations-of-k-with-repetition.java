import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int k,n;
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken()); // 1이상 K이하
        n = Integer.parseInt(st.nextToken()); // n번 반복

        int currNum = 1;
        makeNumber(currNum);

    }

    public static void makeNumber(int currNum){
        if(currNum == n+1){
            print(numList);
            return;
        }
        for(int i = 1; i<=k; i++){
            numList.add(i);
            makeNumber(currNum+1);
            numList.remove(numList.size()-1);
        }
    }
    public static void print(List<Integer> numList){
        for(int num : numList){
            System.out.print(num +" ");
        }
        System.out.println();
    }

}