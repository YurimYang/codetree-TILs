import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Product product = new Product("codetree", 50);
        System.out.println("product " + product.code + " is " + product.name);
        st = new StringTokenizer(br.readLine());
        String productName = st.nextToken();
        int productCode = Integer.parseInt(st.nextToken());
        product = new Product(productName, productCode);
        System.out.println("product " + product.code + " is " + product.name);
    }
}

class Product{
    String name;
    int code;

    public Product(String name, int code){
        this.name = name;
        this.code = code;
    }
}