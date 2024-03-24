import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Student2[] studentArr = new Student2[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student2 student = new Student2(name, kor, eng, math);
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
class Student2 implements Comparable<Student2> {

    String name;
    int kor;
    int eng;
    int math;

    public Student2(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student2 student) {
        if (this.kor == student.kor) {
            if (this.eng == student.eng) {
                return student.math - this.math;
            }
            return student.eng - this.eng;
        }
        return student.kor - this.kor;
    }
}