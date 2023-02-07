import java.util.*;

public class LC63 {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();

        int n = scanner.nextInt();
        int t = n;
        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Vector<Integer> set = map.get(x);
            if (set == null)
                set = new Vector<>();
            set.add(y);
            map.put(x, set);
        }
        int claster = 0;

        for (int x : map.keySet()) {
            Vector<Integer> set = map.get(x);
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int y = iterator.next();
                for (int x1 : map.keySet()) {
                    // System.out.print("����");
                    // System.out.print(x);
                    // System.out.print(" ");
                    // System.out.print(y);
                    // System.out.print(" ");
                    // System.out.print(x1);
                    //
                    // System.out.println(" ");
                    Vector<Integer> set1 = map.get(x1);
                    if (x == x1) {
                        claster += set.size();
                        continue;
                    }
                    if (set1.contains(y - (x - x1))) {
                        // System.out.print("��һ��");
                        // System.out.print(x);
                        // System.out.print(" ");
                        // System.out.print(y);
                        // System.out.print(" ");
                        // System.out.print(x1);
                        // System.out.print(" ");
                        // System.out.print(y - (x - x1));
                        // System.out.println(" ");
                        claster++;
                    }
                    if (set1.contains(y + (x - x1))) {
                        // System.out.print("�ڶ���");
                        // System.out.print(x);
                        // System.out.print(" ");
                        // System.out.print(y);
                        // System.out.print(" ");
                        // System.out.print(x1);
                        // System.out.print(" ");
                        // System.out.print(y + (x - x1));
                        // System.out.println(" ");
                        claster++;
                    }
                    if (set1.contains(y)) {
                        // System.out.print("������");
                        // System.out.print(x);
                        // System.out.print(" ");
                        // System.out.print(y);
                        // System.out.print(" ");
                        // System.out.print(x1);
                        // System.out.print(" ");
                        // System.out.print(y);
                        // System.out.println(" ");
                        claster++;
                    }
                }
            }
        }
        // System.out.println(claster);
        System.out.println((claster - n) / 2);

    }
}
