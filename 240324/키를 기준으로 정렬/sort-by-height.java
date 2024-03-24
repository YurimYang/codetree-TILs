import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException  {
        int n = Integer.parseInt(br.readLine());
        Student[] studentArr = new Student[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Student student = new Student(name, height, weight);
            studentArr[i] = student;
        }
        Arrays.sort(studentArr);
        for(int i = 0; i<n; i++){
            System.out.println(studentArr[i].name + " " + studentArr[i].height + " " + studentArr[i].weight);
        }
    }
}

class Student implements Comparable<Student>{
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight){
        this.name = name;
        this.height= height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student s) {
        return this.height - s.height;
    }
}