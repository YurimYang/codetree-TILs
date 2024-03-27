import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // N명의 사람
        int k = Integer.parseInt(st.nextToken()); // 사진의 크기 : 양쪽 끝에 있는 x값 끼리의 차
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            String point = st.nextToken();
            if(point.equals("G")){
                hm.put(key,1);
            }else{
                hm.put(key,2);
            }
        }

        for(int start : hm.keySet()){
            int sumTmp = 0;
            for(int i = start; i<start+k+1; i++){
                sumTmp += hm.getOrDefault(i, 0);
            }
            max = Math.max(max, sumTmp);
        }
        System.out.println(max);
    }
}