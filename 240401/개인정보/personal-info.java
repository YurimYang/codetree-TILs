import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Students> studentList;

    public static void main(String args[]) throws IOException {
        studentList = new ArrayList<>();
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            studentList.add(new Students(name, height, weight));
        }
        sortName();
        print("name");
        sortHeight();
        print("height");
    }

    public static void sortName(){
        Collections.sort(studentList, new Comparator<Students>() {
            @Override
            public int compare(Students a, Students b) {
                return a.name.compareTo(b.name);
            }
        });
    }

    public static void sortHeight(){
        Collections.sort(studentList, new Comparator<Students>() {
            @Override
            public int compare(Students a, Students b) {
                return b.height - a.height;
            }
        });
    }

    public static void print(String tmp){
        System.out.println(tmp);
        for(int i = 0; i<5; i++){
            Students student = studentList.get(i);
            System.out.println(student.name + " " + student.height + " " + student.weight);
        }
        System.out.println();
    }
}

class Students {
    String name;
    int height;
    double weight;

    public Students(String name, int height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}