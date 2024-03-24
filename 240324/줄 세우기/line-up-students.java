import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Student4[] studentArr = new Student4[n];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Student4 student = new Student4(h,w,i+1);
            studentArr[i] = student;
        }

        Arrays.sort(studentArr);
        for (int i = 0; i < n; i++) {
            System.out.println(
                studentArr[i].h + " " + studentArr[i].w + " "
                    + studentArr[i].num);
        }

    }
}

class Student4 implements Comparable<Student4>{
    int h;
    int w;
    int num;

    public Student4(int h, int w, int num){
        this.h = h;
        this.w = w;
        this.num = num;
    }

    @Override
    public int compareTo(Student4 student) {
        if(this.h == student.h){
            if(this.w == student.w){
                return this.num - student.num;
            }
            return student.w - this.w;
        }
        return student.h - this.h;
    }
}