import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //1이상 n이하
        m = Integer.parseInt(st.nextToken()); //m개의 숫자 뽑기
        checkNumber(1,0);
    }

    public static void checkNumber(int num, int cnt){
        if(num == n+1){
            if(cnt == m){
                sb = new StringBuilder();
                printNum();
            }
            return;
        }
        
        nums.add(num);
        checkNumber(num+1, cnt +1);
        nums.remove(nums.size()-1);

        checkNumber(num+1, cnt);

    }

    public static void printNum(){
        for(int n : nums){
            sb.append(n +" ");
        }
        System.out.println(sb);
    }
}