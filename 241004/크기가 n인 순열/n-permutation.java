import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited;
    static int n = 0;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new int[n+1];

        count(0);

    }

    public static void print(){
        for(int i = 0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
        
    }

    public static void count(int len){
        if(len == n){
            print();
            return;
        }

        for(int i = 1; i<=n; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                answer.add(i);
                count(len + 1);
                visited[i] = 0;
                answer.remove(answer.size() - 1);
            }
        }
    }
}