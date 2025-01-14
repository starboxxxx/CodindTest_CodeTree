import java.util.*;
class Product {
    String product;
    int code;

    public Product() {
        this.product = "codetree";
        this.code = 50;
    }

    public Product(String product, int code) {
        this.product = product;
        this.code = code;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product product1 = new Product();

        String product = sc.next();
        int code = sc.nextInt();
        Product product2 = new Product(product, code);

        System.out.println("product " + product1.code + " is " + product1.product);
        System.out.println("product " + product2.code + " is " + product2.product);


    }
}