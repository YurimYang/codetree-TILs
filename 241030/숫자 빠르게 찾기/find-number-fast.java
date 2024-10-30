import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] numStr = br.readLine().split(" ");

        List<Integer> numList = new ArrayList<>();

        for(String num : numStr){
            numList.add(Integer.parseInt(num));
        }

        for(int i = 0; i<m; i++){
            int number = Integer.parseInt(br.readLine());

            long s = 0;
            long e = n-1;

            long answer = -1;
            while(s <= e){
                long mid = (s+e) / 2;
                if(number == numList.get((int) mid)){
                    answer = mid + 1;
                    break;
                }
                else if(number > numList.get((int) mid)){ 
                    s = mid + 1;
                } else {
                    e = mid-1;
                }
            }

            System.out.println(answer);
        }
    }
}