public class Main {
    public static void main(String[] args) {
        for (int i = 0; i<5; i++) {
            print10Stars();
        }
    }


    public static void print10Stars() {
        for (int j = 0; j<10; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}