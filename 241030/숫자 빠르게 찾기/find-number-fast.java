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

        Collections.sort(numList);

        for(int i = 0; i<m; i++){
            int number = Integer.parseInt(br.readLine());

            int index = Collections.binarySearch(numList, number);
            if(index >= 0){
                System.out.println(index + 1 );
            } else {
                System.out.println(-1);
            }

            // long s = (long) numList.get(0);
            // long e = (long) numList.get(numList.size()-1);

            // long answer = -1;
            // while(s <= e){
            //     long mid = (s+e) / 2;
            //     if(number == mid){
            //         answer = numList.indexOf(mid) + 1;
            //     }
            //     else if(number > mid){ 
            //         s = mid + 1;
            //     } else {
            //         e = mid-1;
            //     }
            // }

            // System.out.println(answer);
        }
    }
}