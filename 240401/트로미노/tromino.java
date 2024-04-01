import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static int[][] grid;

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        List<Integer> ansList = new ArrayList<>();
        int ver1Max = Integer.MIN_VALUE;
        int ver2Max = Integer.MIN_VALUE;
        int ver3Max = Integer.MIN_VALUE;


        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int currRow = 0; currRow < n; currRow++){
            ver1Max = Math.max(ver1Max, version1(currRow));
        }
        for(int currCol = 0; currCol <m ; currCol++){
            ver2Max = Math.max(ver2Max, version2(currCol));
        }
        for(int currCol = 0; currCol<m-1; currCol++){
            for(int currRow = 0; currRow <n-1; currRow++){
                ver3Max = Math.max(ver3Max,version3(currCol, currRow));
            }

        }

        ansList.add(ver1Max);
        ansList.add(ver2Max);
        ansList.add(ver3Max);
        Collections.sort(ansList);
        System.out.println(ansList.get(2));
    }
    public static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y<m;
    }
    public static int version3(int currCol, int currRow){
        int minNum = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = currCol; i<currCol+2; i++){
            for(int j = currRow; j<currRow+2; j++){
                if(inRange(i,j)){
                    ans+= grid[i][j];
                    minNum = Math.min(minNum, grid[i][j]);
                }
            }
        }
        ans -= minNum;
        return ans;
    }

    public static int version1(int currRow){ //가로 ---
        int finalAns = Integer.MIN_VALUE;
        for(int j = 0; j< m-2; j++){
            int ans = 0;
            for(int k = j; k < j+3; k++){
                ans += grid[currRow][k];
            }
            finalAns = Math.max(finalAns, ans);
        }
        return finalAns;
    }

    public static int version2(int currCol){ //세로 |
        int finalAns = Integer.MIN_VALUE;
        for(int j = 0; j<n-2; j++){
            int ans = 0;
            for(int k = j; k< j+3; k++){
                ans += grid[k][currCol];
            }
            finalAns = Math.max(finalAns, ans);
        }
        return finalAns;
    }
}