import java.util.Scanner;

public class Main {
    public static final int MAX_T = 1000000;
    
    public static int n, m;
    public static int[] posA = new int[MAX_T + 1];
    public static int[] posB = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        // A가 매 초마다 서있는 위치를 기록
        int timeA = 1;
        for(int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            
            while(t-- > 0) {
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }
        
        // B가 매 초마다 서있는 위치를 기록
        int timeB = 1;
        for(int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            
            while(t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }
        
        int leader = 0, ans = 0;
        for(int i = 1; i < timeA; i++) {
            if(posA[i] > posB[i]) {
                if(leader == 2)
                    ans++;
                leader = 1; 
            }
            else if(posA[i] < posB[i]) {
                if(leader == 1)
                    ans++;
                leader = 2; 
            }
        }
        
        System.out.print(ans);
    }
}