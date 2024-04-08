import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int l, q;
    static HashMap<String, int[]> sushi = new HashMap<>();
    static HashMap<String, int[]> customers = new HashMap<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken()); //초밥벨트의 길이
        q = Integer.parseInt(st.nextToken()); //명령의 수
        for(int i = 1; i<q+1; i++){

            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            update(time);

            if(type == 100){
                int x = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                cheif(time, x, name);
            } else if(type == 200){
                int x = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                customer(x,name,num);
            } else {
                photo();
            }
        }

    }
    public static void update(int time){
        List<String> forDelete = new ArrayList<>();
        for(String name : sushi.keySet()){
            int[] update = new int[]{time, ((time - sushi.get(name)[0]) + sushi.get(name)[1]) % l};
            sushi.put(name, update);
            if(customers.containsKey(name)){
                if(customers.get(name)[0] == sushi.get(name)[1]){
                    forDelete.add(name);
                    customers.put(name, new int[]{customers.get(name)[0],customers.get(name)[1]-1});
                }
            }
        }
        for(String name : forDelete){
            sushi.remove(name);
            if(customers.get(name)[1] == 0){
                customers.remove(name);
            }
        }
    }


    public static void cheif(int time, int x, String name){
        sushi.put(name, new int[]{time, x});//t, x : 시간, 장소
        update(time);
    }

    public static void customer(int x, String name, int num){
        if(sushi.get(name)[1] == x){
            sushi.remove(name);
            num--;
        }
        if(num > 0){
            customers.put(name, new int[]{x, num}); //x, num : 장소, 개수
        }
    }
    public static void photo(){
        int leftPeople = customers.size();
        int leftSushi = sushi.size();
        System.out.println(leftPeople + " " + leftSushi);
    }
}