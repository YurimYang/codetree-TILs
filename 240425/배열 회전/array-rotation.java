import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, k; 
    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열
        k = Integer.parseInt(st.nextToken()); //회전 개수

        //numbers 초기화
        numbers = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<k; i++){
            rotate();
        }

        //회전 결과물 출력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(numbers[i][j] +" ");
            }
            System.out.println();
        }

        
    }

    // 배열을 r번 회전시키는 함수
    public static void rotate() {
        
        int check = Math.min(n,m) / 2; //돌려야할 사각형의 개수 계산 

        for(int cnt = 0; cnt < check; cnt++){
            int n_max = n - cnt - 1;
            int m_max = m - cnt - 1;

            //레이어의 왼쪽 상단 값 
            int tmp = numbers[cnt][cnt];

            //위 -> 왼쪽 
            for(int i = cnt; i<m_max; i++){
                numbers[cnt][i] = numbers[cnt][i+1];
            }

            //오른쪽 -> 위
            for(int i = cnt; i< n_max; i++){
                numbers[i][m_max] = numbers[i+1][m_max];
            }

            //아래 -> 오른쪽
            for(int i = m_max; i> cnt; i--){
                numbers[n_max][i] = numbers[n_max][i-1];
            }

            //왼쪽 -> 아래
            for(int i = n_max; i > cnt; i--){
                numbers[i][cnt] = numbers[i-1][cnt];
            }

            numbers[cnt+1][cnt] = tmp;
        } 
    }
}