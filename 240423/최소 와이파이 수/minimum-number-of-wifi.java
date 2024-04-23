import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //0,1로 이루어진 n개의 숫자
        int m = Integer.parseInt(st.nextToken()); //와이파이 설치 거리 m이내 사용 가능 
        

        //사람들 사는 지역정보 초기화 
        int[] people = new int[n+1];
        st = new StringTokenizer(br.readLine());    
        for(int i = 1; i<n+1; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        //지역정보를 돌며 와이파이 설치 거리 확인
        int wifiCnt = 0;
        //boolean[] isCovered = false;
        for(int i = 1; i<n+1; i++){
            if(people[i] == 1){
                wifiCnt++;
                i += 2*m;
            }
        }

        System.out.println(wifiCnt);



        
    }
}

// 1: 사람 o <-> 0: 사람 x