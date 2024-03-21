import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] dx = new int[]{1,-1,0,0};//동서남북
        int[] dy = new int[]{0,0,-1,1};//동서남북
        int initX = 0;
        int initY = 0;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(key)){
                hashMap.put(key,hashMap.get(key)+num);
                continue;
            }
            hashMap.put(key,num);
        }

        for(String key : hashMap.keySet())
            if(key.equals("E")){
                initX += dx[0] * hashMap.get(key);
            }else if(key.equals("W")){
                initX += dx[1]* hashMap.get(key);
            }else if(key.equals("S")){
                initY += dy[2]* hashMap.get(key);
            }else{
                initY += dy[3]* hashMap.get(key);
            }

        System.out.println(initX + " " + initY);
    }
}