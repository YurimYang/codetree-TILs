import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer> nums = new ArrayList<>();
    static List<Integer> numsFirst = new ArrayList<>();
    static List<Integer> numsSecond = new ArrayList<>();
    static int min = Integer.MAX_VALUE;


    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        backTracking(0,0);
        System.out.println(min);
    }

    public static void backTracking(int idx, int cnt) {
        if (idx == nums.size()) {
            if(cnt == n){
                min = Math.min(min, calc());
            }
            return;
        }
        numsFirst.add(nums.get(idx));
        backTracking(idx + 1, cnt + 1);
        numsFirst.remove(numsFirst.size() - 1);
        backTracking(idx + 1, cnt);
    }

    public static int calc() {
        makeSecondList();
        int firstSum = 0;
        int secondSum = 0;
        for (int first : numsFirst) {
            firstSum += first;
        }
        for (int second : numsSecond) {
            secondSum += second;
        }
        return Math.abs(firstSum - secondSum);
    }

    public static void makeSecondList() {
        numsSecond = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            if (!numsFirst.contains(nums.get(i))) {
                numsSecond.add(nums.get(i));
            }
        }
    }


}