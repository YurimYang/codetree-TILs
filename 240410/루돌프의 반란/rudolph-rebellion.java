import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, p, c, d, rr, rc;
    static int[][] grid;
    //static Point[] santa;
    static HashMap<Integer, Point> santa = new HashMap<>();
    static boolean[] isLive;
    static int[] santaScore;
    static Point Rudolph;
    static int[] rdx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] rdy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] sdx = new int[]{-1, 1, 0, 0};
    static int[] sdy = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //게임판 크기
        m = Integer.parseInt(st.nextToken()); //게임 턴 수
        p = Integer.parseInt(st.nextToken()); //산타의 수
        c = Integer.parseInt(st.nextToken()); //루돌프의 힘
        d = Integer.parseInt(st.nextToken()); //산타의 힘

        grid = new int[n + 1][n + 1];
        santaScore = new int[n + 1];
        isLive = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        rr = Integer.parseInt(st.nextToken()); //루돌프 초기 위치
        rc = Integer.parseInt(st.nextToken());
        Rudolph = new Point(rr, rc);

        //산타의 위치 표시
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            santa.put(id, new Point(x, y));
            grid[x][y] = id;
            isLive[id] = true;

        }

        Move();
        for (int i = 0; i < santaScore.length; i++) {
            System.out.print(santaScore[i + 1] + " ");
        }
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static void Move() {
        for (int j = 0; j < m; j++) {
            RudolphMove(Rudolph.x, Rudolph.y);
            SantaMove();
            for (int i = 0; i < p; i++) {
                if (isLive[i]) {
                    santaScore[i + 1]++;
                }
            }
        }
    }

    public static Point getDistance(int r, int c) {
        int minDistance = Integer.MAX_VALUE;
        List<Point> targetSantaList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int distance = (int) (Math.pow(santa.get(i + 1).x - r, 2) + Math.pow(
                santa.get(i + 1).y - c,
                2));
            minDistance = Math.min(minDistance, distance);
            if (minDistance == distance) { //minDistance가 바뀐 경우
                targetSantaList.add(santa.get(i + 1));
            }
        }
        if (targetSantaList.size() > 1) {
            Collections.sort(targetSantaList);
        }
        return targetSantaList.get(0);
    }

    public static void RudolphMove(int x, int y) {
        Point targetSanta = getDistance(x, y);
        int minPos = Integer.MAX_VALUE;
        int movedDir = -1;

        for (int i = 0; i < 8; i++) {
            int nx = x + rdx[i];
            int ny = y + rdy[i];

            if (inRange(nx, ny)) {
                int distance = (int) (Math.pow(targetSanta.x - nx, 2) + Math.pow(targetSanta.y - ny,
                    2));
                minPos = Math.min(minPos, distance);
                if (distance == minPos) {
                    movedDir = i;
                }
            }
        }
        if (movedDir != -1) {
            Rudolph = new Point(x + rdx[movedDir], y + rdy[movedDir]);
            isAttackedByRudolph(movedDir);
        }
    }


    public static void isAttackedByRudolph(int pos) {
        for (int i = 0; i < p; i++) {
            if (santa.get(i + 1).x == Rudolph.x && santa.get(i + 1).y == Rudolph.y) {
                santaScore[i + 1] += c;
                santa.get(i + 1).x += -rdx[pos] * c;
                santa.get(i + 1).y += -rdy[pos] * c;
                if (!inRange(santa.get(i + 1).x, santa.get(i + 1).y)) {
                    isLive[i + 1] = false;
                }
            }
        }
    }


    public static void SantaMove() {
        for (int i = 0; i < p; i++) {
            int minPos = Integer.MAX_VALUE;
            int movedDir = -1;
            for (int j = 0; j < 4; j++) {
                int nx = santa.get(i + 1).x + sdx[j];
                int ny = santa.get(i + 1).y + sdy[j];
                if (inRange(nx, ny)) {
                    int distance = (int) (Math.pow(Rudolph.x - nx, 2) + Math.pow(Rudolph.y - ny,
                        2));
                    minPos = Math.min(minPos, distance);
                    if (distance == minPos) {
                        movedDir = j;
                    }
                }
            }
            if (movedDir != -1) {
                grid[santa.get(i + 1).x][santa.get(i + 1).y] = 0;
                santa.get(i + 1).x += sdx[movedDir];
                santa.get(i + 1).y += sdy[movedDir];
                if (!isAttackedBySanta(movedDir, santa.get(i + 1))) {
                    santaScore[i + 1] += d;
                    //밀려났을 때 산타가 죽는 경우
                    if (!inRange(santa.get(i + 1).x, santa.get(i + 1).y)) {
                        isLive[i + 1] = false;
                    }
                    //만약, 해당 자리에 산타가 있을 경우
                    if (isLive[i+1] && grid[santa.get(i + 1).x][santa.get(i + 1).y] > 0) {
                        santa.get(grid[santa.get(i + 1).x][santa.get(i + 1).y]).x += -sdx[i];
                        santa.get(grid[santa.get(i + 1).x][santa.get(i + 1).y]).y += -sdy[i];
                    }
                }
                if(isLive[i+1]){
                    grid[santa.get(i + 1).x][santa.get(i + 1).y] = i + 1;
                }
            }
        }
    }

    public static boolean isAttackedBySanta(int pos, Point santa) {
        if (santa.x == Rudolph.x && santa.y == Rudolph.y) {
            santa.x += -rdx[pos] * d;
            santa.y += -rdy[pos] * d;
            return false;
        }
        return true;
    }


}


class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {
        if (this.x == point.x) {
            return point.y - this.y;
        }
        return point.x - this.x;
    }

}