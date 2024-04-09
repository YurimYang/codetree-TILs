import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_HOSPITAL = 13;
    
    public static int n, m;
    public static int minDistance = INT_MAX;
    public static ArrayList<Pair> people = new ArrayList<>();
    public static ArrayList<Pair> hospitals = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_HOSPITAL];
    
    // 사람과 병원 사이의 거리를 구하여 반환해줍니다.
    public static int getDistance(Pair person, Pair hospital) {
        return Math.abs(person.x - hospital.x) + Math.abs(person.y - hospital.y);
    }
    
    // m 개의 병원이 선택됐을 때 각 사람의 병원 거리에 대한 합을 반환해줍니다.
    public static int getCurrMinDistance() {
        int currMinDistance = 0;
    
        // 각 사람에 대하여 가장 가까운 병원의 거리를 구합니다.
        for(int i = 0; i < people.size(); i++) {
            int singleMin = INT_MAX;
            for(int j = 0; j < hospitals.size(); j++) {
                if(visited[j])
                    singleMin = Math.min(singleMin, 
                                         getDistance(people.get(i), hospitals.get(j)));
            }
            currMinDistance += singleMin;
        }
    
        return currMinDistance;
    }
    
    public static void searchMinDistance(int cnt, int lastIdx) {
        // m개의 병원이 선택됐을 경우 병원 거리의 총합을 구해줍니다.
        if(cnt == m)  {
            minDistance = Math.min(minDistance, getCurrMinDistance());
            return;
        }
    
        // 뽑을 수 있는 병원의 후보들을 탐색합니다.
        for(int i = lastIdx + 1; i < hospitals.size(); i++) { 
            visited[i] = true;
            searchMinDistance(cnt + 1, i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int buffer = sc.nextInt();
                if(buffer == 1)
                    people.add(new Pair(i, j));
                else if(buffer == 2)
                    hospitals.add(new Pair(i, j));
            }

        searchMinDistance(0, -1);
        System.out.print(minDistance);
    }
}