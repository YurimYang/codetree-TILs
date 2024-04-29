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
    }
    //오른쪽 이동
    public static int goRight(int curr, int x){
        for(int i = curr; i< curr+x+1; i++){
            grid.put(i, grid.getOrDefault(i, 0) + 1);
        }
        curr += x;
        return curr;
    }

    //왼쪽 이동
    public static int goLeft(int curr, int x){
        for(int i = curr; i> curr - x - 1; i--){
            grid.put(i, grid.getOrDefault(i,0) + 1);
        }
        curr -= x;
        return curr;
    }

    //중복된 위치 찾기 
    public static int findDuplicatePlace(){
        int answer = 0;
        boolean isMaintain = false;
        int cnt = 0;
        List<Integer> keySet = new ArrayList<>(grid.keySet());
        Collections.sort(keySet);
        for(int key :keySet){
            if(grid.get(key) > 1){
                answer ++;
                isMaintain = true;
            } else if (grid.get(key) == 1 && isMaintain){
                cnt++;
                isMaintain = false;
            } else {
                isMaintain = false;
            }
        }
        return answer - cnt - 1;
    }
}