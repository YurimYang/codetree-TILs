import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
       st = new StringTokenizer(br.readLine());
       String code = st.nextToken();
       String color = st.nextToken();
       int second = Integer.parseInt(st.nextToken());
       Bomb bomb = new Bomb(code, color, second);
       System.out.println("code : " + bomb.code);
       System.out.println("color : " + bomb.color);
       System.out.println("second : " + bomb.second);
    }
}

class Bomb{
    String code;
    String color;
    int second;

    public Bomb(String code, String color, int second){
        this.code = code;
        this.color = color;
        this.second = second;
    }
}