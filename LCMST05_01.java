import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class LCMST05_01 {
    static Vector<Set<Integer>> vector = new Vector<>();

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 40001; i++) {
            Set<Integer> set = new HashSet<>();
            vector.add(set);
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Set<Integer> set1 = vector.get(u);
            set1.add(v);
            vector.set(u, set1);

            Set<Integer> set2 = vector.get(v);
            set2.add(u);
            vector.set(v, set2);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int count = 0;
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            Set<Integer> set1 = vector.get(u);
            Set<Integer> set2 = vector.get(v);
            for (int friend : set1) {
                if (set2.contains(friend))
                    count++;
            }
            System.out.println(count);
        }
    }
}
