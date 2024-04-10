import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, p, c, d, rr, rc;
    static int[][] grid;
    static Point[] santa;
    static int[] santaScore;
    static Point Rudolph;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //게임판 크기
        m = Integer.parseInt(st.nextToken()); //게임 턴 수
        p = Integer.parseInt(st.nextToken()); //산타의 수
        c = Integer.parseInt(st.nextToken()); //루돌프의 힘
        d = Integer.parseInt(st.nextToken()); //산타의 힘

        grid = new int[n + 1][n + 1];
        santa = new Point[n + 1];
        santaScore = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        rr = Integer.parseInt(st.nextToken()); //루돌프 초기 위치
        rc = Integer.parseInt(st.nextToken());
        Rudolph = new Point(rr, rc);

        //산타의 위치 표시
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            santa[i + 1] = new Point(x, y);
        }


    }

    public static void Move() {
        RudolphMove(Rudolph.x, Rudolph.y);
        SantaMove();

    }

    public static Point getDistance(int r, int c) {
        int minDistance = Integer.MAX_VALUE;
        List<Point> targetSantaList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int distance = (int) (Math.pow(santa[i + 1].x - r, 2) + Math.pow(santa[i + 1].y - c,
                2));
            minDistance = Math.min(minDistance, distance);
            if (minDistance == distance) { //minDistance가 바뀐 경우
                targetSantaList.add(santa[i + 1]);
            }
        }
        if (targetSantaList.size() > 1) {
            Collections.sort(targetSantaList);
        }
        return targetSantaList.get(0);
    }

    public static void RudolphMove(int x, int y) {
        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

        Point targetSanta = getDistance(x, y);
        int minPos = Integer.MAX_VALUE;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny)) {
                int distance = (int) (Math.pow(targetSanta.x - nx, 2) + Math.pow(targetSanta.y - ny,
                    2));
                minPos = Math.min(minPos, distance);
                if (distance == minPos) {
                    Rudolph = new Point(nx, ny);
                    isAttackedByRudolph(i);
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean isAttackedByRudolph(int pos) {
        for (int i = 0; i < p; i++) {
            if (santa[i + 1].x == Rudolph.x && santa[i + 1].y == Rudolph.y) {
                santaScore[i + 1] += c;
                attackedByRudolphMovement(pos, santa[i + 1]);
                return false;
            }
        }
        return true;
    }


    public static void attackedByRudolphMovement(int pos, Point santa) {
        if (pos == 0) {
            santa.x -= c;
            santa.y -= c;
        } else if (pos == 1) {
            santa.x -= c;
        } else if (pos == 2) {
            santa.x -= c;
            santa.y += c;
        } else if (pos == 3) {
            santa.y += c;
        } else if (pos == 4) {
            santa.x += c;
            santa.y += c;
        } else if (pos == 5) {
            santa.x += c;
        } else if (pos == 6) {
            santa.x += c;
            santa.y -= c;
        } else if (pos == 7) {
            santa.y -= c;
        }
    }


    public static void SantaMove() {
        int[] dx = new int[]{-1, 1, 0, 0}; //상하좌우
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < p; i++) {
            int minPos = Integer.MAX_VALUE;
            for (int j = 0; j < 4; j++) {
                int nx = santa[i + 1].x + dx[i];
                int ny = santa[i + 1].y + dy[i];

                if (inRange(nx, ny)) {
                    int distance = (int) (Math.pow(Rudolph.x - nx, 2) + Math.pow(Rudolph.y - ny,
                        2));
                    minPos = Math.min(minPos, distance);
                    if (distance == minPos) {
                        santa[i + 1].x = nx;
                        santa[i + 1].y = ny;
                        if (!isAttackedBySanta(j ,santa[i + 1])) {
                            santaScore[i + 1] += d;
                        }
                    }
                }
            }
        }

    }

    public static boolean isAttackedBySanta(int pos, Point santa) {
        if (santa.x == Rudolph.x && santa.y == Rudolph.y) {
            attackedBySantaMovement(pos, santa);
            return false;
        }
        return true;
    }

    public static void attackedBySantaMovement(int pos, Point santa) {
        if (pos == 0) {
            santa.x += d;
        } else if (pos == 1) {
            santa.x -= d;
        } else if (pos == 2) {
            santa.y += d;
        } else if (pos == 3) {
            santa.y -= d;
        }
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