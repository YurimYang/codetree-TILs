import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Student3[] studentArr = new Student3[n];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student3 student = new Student3(name, kor, eng, math);
            studentArr[i] = student;
        }
        Arrays.sort(studentArr);
        for (int i = 0; i < n; i++) {
            System.out.println(
                studentArr[i].name + " " + studentArr[i].kor + " " + studentArr[i].eng + " "
                    + studentArr[i].math);
        }
    }
}

class Student3 implements Comparable<Student3>{
    String name;
    int kor;
    int eng;
    int math;

    public Student3(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    @Override
    public int compareTo(Student3 student) {
        return (this.kor + this.eng + this.math) - (student.kor+ student.eng + student.math) ;
    }
}