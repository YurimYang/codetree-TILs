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

        for(int i = 0; i<len; i++){
            sentence[i] = 0;
            while(i-sentence[i] - 1 >= 0 && i+sentence[i] + 1<len 
                    && newLine[i-sentence[i]-1] == newLine[i+sentence[i] +1]){
                sentence[i]++;
            }
        }

        int max = 0;
        for(int i = 0; i<len; i++){
            //System.out.println(sentence[i]);
            max = Math.max(max, sentence[i]);
        }
        
        System.out.println(max);
    }
}