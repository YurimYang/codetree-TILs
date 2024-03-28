import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y);
        }

        Point[] point_three = new Point[3];
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<n-2; i++){
            point_three[0] = points[i];
            for(int j = i+1; j<n-1; j++){
                point_three[1] = points[j];
                for(int k = j+1; k<n; k++){
                    point_three[2] = points[k];
                    if(isParallel(point_three)){
                        maxSum = Math.max(maxSum, calculateTriangle(point_three));
                    }
                }
            }
        }
        System.out.println(maxSum);
    }

    public static boolean isParallel(Point[] point_three){
        int duplicateX = 0;
        int duplicateY = 0;
        for(int i = 0; i<2; i++){
            for(int j = i+1; j<3; j++){
                if(point_three[i].x == point_three[j].x){
                    duplicateX++;
                }else if(point_three[i].y == point_three[j].y){
                    duplicateY++;
                }

            }
        }
        if(duplicateX == 1 && duplicateY == 1){
            return true;
        }
        return false;
    }

    public static int calculateTriangle(Point[] point_three){
        int width = 0;
        int height = 0;
        int sum = 0;
        for(int i = 0; i<2; i++){
            for(int j = i+1; j<3; j++){
                if(point_three[i].x == point_three[j].x){
                    height = Math.abs(point_three[j].y - point_three[i].y);
                }else if(point_three[i].y == point_three[j].y){
                    width = Math.abs(point_three[j].x - point_three[i].x);
                }
                sum = height * width;
            }
        }
        return sum;
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}