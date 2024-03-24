import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        NextLevel firstNextLevel = new NextLevel();
        NextLevel secondNextLevel = new NextLevel(inputArr[0], Integer.parseInt(inputArr[1]));
        System.out.println("user " + firstNextLevel.id + " lv " + firstNextLevel.level);
        System.out.println("user " + secondNextLevel.id + " lv " + secondNextLevel.level);
    }   
}

class NextLevel{
    String id;
    int level;

    public NextLevel(String id, int level){
        this.id = id;
        this.level = level;
    }

    public NextLevel(){
        this.id = "codetree";
        this.level = 10;
    }
}