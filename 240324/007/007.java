import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        SecretCode secretCode = new SecretCode(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]));
        System.out.println("secret code : " + secretCode.sc);
        System.out.println("meeting point : " + secretCode.mp);
        System.out.println("time : " + secretCode.time);
    }
}

class SecretCode{
    String sc;
    String mp;
    int time;

    public SecretCode(String secretCode, String mappingPoint, int time){
        this.sc = secretCode;
        this.mp = mappingPoint;
        this.time = time;
    }
}