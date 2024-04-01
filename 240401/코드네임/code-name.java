import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<Code> codenameList = new ArrayList<>();
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            codenameList.add(new Code(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(codenameList);
        System.out.print(codenameList.get(0).code + " " + codenameList.get(0).point);
    }
}

class Code implements Comparable<Code>{
    String code;
    int point;

    public Code(String code, int point){
        this.code = code;
        this.point = point;
    }
    @Override
    public int compareTo(Code code) {
        return  this.point - code.point;
    }
}