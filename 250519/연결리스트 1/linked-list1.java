import java.util.*;

class Node {
    String message;
    Node preview;
    Node next;

    public Node(String message) {
        this.message = message;
        this.preview = null;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String message = sc.next();
        Node currentNode = new Node(message);

        int n = sc.nextInt();

        while (n-- > 0) {
            int k = sc.nextInt();

            if (k == 1) {
                String value = sc.next();
                Node newNode = new Node(value);
                newNode.next = currentNode;
                if (currentNode.preview != null) {
                    newNode.preview = currentNode.preview;
                    currentNode.preview.next = newNode;
                }
                currentNode.preview = newNode;
            }

            else if (k == 2) {
                String value = sc.next();
                Node newNode = new Node(value);
                newNode.preview = currentNode;
                if (currentNode.next != null) {
                    newNode.next = currentNode.next;
                    currentNode.next.preview = newNode;
                }
                currentNode.next = newNode;
            }
            else if (k == 3) {
                if (currentNode.preview != null) {
                    currentNode = currentNode.preview;
                }
            }
            else {
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
            }

            if (currentNode.preview == null) {
                System.out.print("(Null) ");
            }
            else {
                System.out.print(currentNode.preview.message + " ");
            }

            System.out.print(currentNode.message + " ");

            if (currentNode.next == null) {
                System.out.print("(Null) ");
            }
            else {
                System.out.print(currentNode.next.message + " ");
            }

            System.out.println();
        }
    }
}