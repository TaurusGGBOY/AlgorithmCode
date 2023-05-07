import java.util.*;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 2) {
            System.out.println(0);
            return;
        }
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        left.put(arr[0], 1);
        for (int i = 2; i < n; i++) {
            right.merge(arr[i], 1, Integer::sum);
        }

        long res = 0;
        for (int j = 1; j < arr.length - 1; j++) {
            for (int i = 0; i < j; i++) {
                int want = -arr[i] + 3 * arr[j];
                res += right.getOrDefault(want, 0);
            }
            left.merge(arr[j], 1, Integer::sum);
            if (right.get(arr[j + 1]) == 1) right.remove(arr[j + 1]);
            else right.merge(arr[j + 1], -1, Integer::sum);
        }

        System.out.println(res);
    }
}
