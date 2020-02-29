import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            Vector<Integer> vec1 = new Vector<>();
            for (int j = 0; j < n; j++) {
                vec1.add(scanner.nextInt());
            }
            Vector<Integer> vec2 = new Vector<>();
            vec2.addAll(vec1);
            vec2.sort(new IntergerComparator());

            Vector<Integer> vector3 = new Vector<>();
            for (int h = 0; h < k; h++) {
                vector3.add(vec1.indexOf(vec2.get(h)) + 1);
            }

            vector3.sort(new IntergerComparator2());
            for (int h = 0; h < k; h++) {
                System.out.print(vector3.get(h));
                System.out.print(" ");
            }

            System.out.println();
        }

    }

    static class IntergerComparator implements Comparator<Integer> {
        public int compare(Integer a1, Integer a2) {
            return -a1 + a2;
        }
    }

    static class IntergerComparator2 implements Comparator<Integer> {
        public int compare(Integer a1, Integer a2) {
            return a1 - a2;
        }
    }
}
