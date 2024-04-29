import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer, Integer> grid = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int curr = 0;

        //grid 초기화
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            if(dir.equals("R")){
                curr = goRight(curr, x);
            } else if (dir.equals("L")){
                curr =  goLeft(curr,x);
            }
        }
        System.out.println(findDuplicatePlace());
        //System.out.println(curr);
    }
    //오른쪽 이동
    public static int goRight(int curr, int x){
        for(int i = curr; i< curr+x; i++){
            grid.put(i, grid.getOrDefault(i+1, 0) + 1);
        }
        curr += x;
        System.out.println("R curr: " + curr);
        return curr;
    }

    //왼쪽 이동
    public static int goLeft(int curr, int x){
        for(int i = curr; i> curr - x; i--){
            grid.put(i, grid.getOrDefault(i,0) + 1);
        }
        curr -= x;

        System.out.println("L curr: " + curr);
        return curr;
    }

    //중복된 위치 찾기 
    public static int findDuplicatePlace(){
        int answer = 0;
        for (int count : grid.values()) {
            if (count > 1) {
                answer++;
            }
        }
        return answer;
    }
}