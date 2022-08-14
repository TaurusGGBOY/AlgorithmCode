import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node root = new Node();
        root.val = 0;
        Map<Integer, Node> map = new HashMap<>();
        map.put(0, root);

        int[] vals = new int[n];
        int[] parents = new int[n];

        for (int i = 0; i < n; i++) vals[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) parents[i] = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        max = Arrays.stream(vals).max().getAsInt();
        if (max <= 0) {
            System.out.println(max);
            return;
        }
        for (int i = 0; i < n; i++) {
            Node p = map.get(parents[i]);
            Node node = new Node();
            node.val = vals[i];
            map.put(i + 1, node);
            if (p.left == null) p.left = node;
            else p.right = node;
        }
        search(root.left);
        System.out.println(max);
    }

    static int search(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, search(node.left));
        int right = Math.max(0, search(node.right));
        int sum = Math.max(0, left + right + node.val);
        max = Math.max(max, sum);
        return Math.max(left + node.val, right + node.val);
    }
}
