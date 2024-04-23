import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] line = br.readLine().toCharArray();
        char[] newLine= new char[2*line.length];
        for(int i = 0; i<line.length * 2; i++){
            if(i%2 == 0){
                newLine[i] = '#';
            } else {
                newLine[i] = line[i / 2];
            }
        }
        int len = newLine.length;
        int[] sentence = new int[len];


        int r = -1;
        int p = -1; 
        for(int i = 0; i<len; i++){
            if(r<i){
                sentence[i] = 0;
            } else {
                int ii = 2 * p - i;
                sentence[i] = Math.min(r-i, sentence[ii]);
            }
            while(i-sentence[i] - 1 >= 0 && i+sentence[i] + 1<len 
                    && newLine[i-sentence[i]-1] == newLine[i+sentence[i] +1]){
                sentence[i]++;
            }
            if(i+sentence[i] > r){
                r = i+ sentence[i];
                p = i;
            }
        }

        int max = 0;
        for(int i = 0; i<len; i++){
            max = Math.max(max, 2 * sentence[i] + 1);
        }
        
        System.out.println(max/2);
    }
}