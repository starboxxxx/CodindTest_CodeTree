import java.util.*;

class Node {
    int num;
    Node preview;
    Node next;

    public Node (int num) {
        this.num = num;
        this.preview = null;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        HashMap<Integer, Node> map = new HashMap<>();
        
        for (int i = 1; i<=n; i++) {
            map.put(i, new Node(i));
        }

        int count = 0;
        while (q-- > 0) {

            count++;

            int k = sc.nextInt();

            if (k == 1) {
                int num = sc.nextInt();

                Node node = map.get(num);

                Node previewNode = node.preview;
                Node nextNode = node.next;

                if (previewNode != null) {
                    previewNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.preview = previewNode;
                }

                node.preview = null;
                node.next = null;
                
            }

            else if (k == 2) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                Node targetNode = map.get(j);
                Node node = map.get(i);

                Node previewNode = node.preview;
                
                node.preview = targetNode;
                targetNode.next = node;
                
                if (previewNode != null) {
                    targetNode.preview = previewNode;
                    previewNode.next = targetNode;
                }
            }

            else if (k == 3) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                Node targetNode = map.get(j);
                Node node = map.get(i);

                Node nextNode = node.next;

                node.next = targetNode;
                targetNode.preview = node;

                if (nextNode != null) {
                    targetNode.next = nextNode;
                    nextNode.preview = targetNode;
                }
            }

            else {
                int i = sc.nextInt();

                Node node = map.get(i);

                if (node.preview == null) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(node.preview.num + " ");
                }

                if (node.next == null) {
                    System.out.println(0);
                }
                else {
                    System.out.println(node.next.num);
                }
            }
        }

        for (int i = 1; i<=n; i++) {
            Node node = map.get(i);

            if (node.next == null) {
                System.out.print(0 + " ");
            }
            else {
                System.out.print(node.next.num + " ");
            }
        }
    }
}