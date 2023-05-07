import java.util.Scanner;

public class Main {

    static int[] arr;

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = scanner.nextInt();
        }
        System.out.println(dfs(1));

    }

    static int dfs(int node) {
        if(node >= arr.length) return 0;
        return Math.max(dfs(2 * node) + arr[node], dfs(2 * node + 1) + arr[node]);
    }
}
