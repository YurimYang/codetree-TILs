import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int k,n= 0;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        count(0);


    }

    public static void printCount(){
        for(int i = 0; i< answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();

    }

    public static  void count(int cnt){
        if(cnt == n){
            printCount();
            return;
        }
        
        for(int i = 1; i<=k; i++){
            answer.add(i);
            count(cnt + 1);
            answer.remove(answer.size() - 1);
        }
    }
}