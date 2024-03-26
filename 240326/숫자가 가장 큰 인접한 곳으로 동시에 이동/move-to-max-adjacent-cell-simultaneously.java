import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, t;
    static int[][] marbles, nextCount, count;
    static List<Pair> pairList;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 격자의 크기
        m = Integer.parseInt(st.nextToken()); // 구슬의 개수
        t = Integer.parseInt(st.nextToken()); // 시간
        marbles = new int[n + 1][n + 1];
        count = new int[n + 1][n + 1];

        pairList = new ArrayList<>();
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                marbles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pairList.add(new Pair(r, c, marbles[r][c]));
        }

        while(t > 0){
            movePair();
            deleteDuplicate();
            t--;
        }

        for(int i = 1; i<=n; i++){
            for(int j =1 ;j<=n; j++){
                answer += count[i][j];
            }
        }
        System.out.println(answer);

    }

    public static void movePair() {
        List<Pair> newPairList = new ArrayList<>();
        nextCount = new int[n + 1][n + 1];
        for(int j = 0; j<pairList.size(); j++){
            Pair targetPair = new Pair(-1,-1,-1);
            for(int i = 0; i<4; i++){
                int xIdx = pairList.get(j).r + dx[i];
                int yIdx = pairList.get(j).c + dy[i];

                if(isInRage(xIdx,yIdx) && marbles[xIdx][yIdx] > targetPair.num){
                    targetPair.r = xIdx;
                    targetPair.c = yIdx;
                    targetPair.num = marbles[xIdx][yIdx];
                }
            }
            nextCount[targetPair.r][targetPair.c]++;
            newPairList.add(targetPair);
        }
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                count[i][j] = nextCount[i][j];

        pairList = newPairList;
    }

    public static boolean isInRage(int r, int c){
        if(1<=r && r <=n && 1<=c && c<=n){
            return true;
        }
        return false;
    }

    public static void deleteDuplicate(){
        for(int i = 1; i<n+1; i++){
            for(int j =1; j<n+1; j++){
                if(count[i][j] > 1){
                    count[i][j] = 0;
                }
            }
        }

    }

}

class Pair {

    int r;
    int c;
    int num;

    public Pair(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }

}