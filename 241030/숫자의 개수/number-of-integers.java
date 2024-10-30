import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m = 0;
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        HashMap<Integer, Integer> numCount = new HashMap<>();
        numArr = new int[n];

        String[] numStr = br.readLine().split(" ");
        for(int i = 0; i<numStr.length; i++){
            numArr[i] = Integer.parseInt(numStr[i]); 
        }

        for(int i = 0; i<m; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(upperBound(num) - lowerBound(num));
        }


        


       
    }

    public static int lowerBound(int num){
        int s = 0;
        int e = n-1;
        int minIdx = n; //같은 값이 시작하는 위치의 최소index이므로 최대로 일단 잡아 놓는다.
        while(s <= e){
            int mid = (s+e) / 2;

            if(numArr[mid] >= num){
                e = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                s = mid + 1;
            }
        }
        return minIdx;
    }

    public static int upperBound(int num){
        int s = 0;
        int e = n-1;
        int maxIdx = n; //같은 값이 시작하는 위치의 최소index이므로 최대로 일단 잡아 놓는다.
        while(s <= e){
            int mid = (s+e) / 2;

            if(numArr[mid] > num){
                e = mid - 1;
                maxIdx = Math.min(maxIdx, mid);
            } else {
                s = mid + 1;
            }
        }
        return maxIdx;
    }
}