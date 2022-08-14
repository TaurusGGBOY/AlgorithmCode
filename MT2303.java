import java.util.*;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Deque<Integer> q = new ArrayDeque<>();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q.offerLast(arr[i]);
            q.offerLast(q.pollFirst());
            q.offerLast(q.pollFirst());
        }
        while (!q.isEmpty()) {
            System.out.print(q.pollLast() + " ");
        }
    }
}
