import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100000;
    
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    public static int find(int target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return mid;
            
            if(arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
    
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();

            // 이진탐색을 진행합니다.
            int index = find(x);

            if(index >= 0)
                System.out.println(index + 1);
            else
                System.out.println(-1);
        }
    }
}