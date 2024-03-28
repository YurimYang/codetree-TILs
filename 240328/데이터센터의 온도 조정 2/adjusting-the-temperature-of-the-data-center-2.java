import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,c,g,h;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()); // a 미만
        g = Integer.parseInt(st.nextToken()); // a 이상, b 이하
        h = Integer.parseInt(st.nextToken()); // b 초과
        Ts[] tArr = new Ts[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tArr[i] = new Ts(a, b);
        }

        int maxB = Integer.MIN_VALUE;
        for(int i = 0 ; i<n; i++){
            maxB = Math.max(maxB, tArr[i].b);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<maxB; i++){
            int total = 0;
            for(Ts t : tArr){
                total += checkTemp(i, t);
            }
            ans = Math.max(ans, total);
        }
        System.out.println(ans);
    }

    public static int checkTemp(int fav, Ts t){
        int sum = 0;
        if(fav < t.a){
            sum += c;
        } else if (t.a<=fav && fav <=t.b){
            sum += g;
        } else if (fav > t.b) {
            sum += h;
        }
        return sum;
    }
}

class Ts{
    int a;
    int b;

    public Ts(int a, int b){
        this.a = a;
        this.b = b;
    }
}