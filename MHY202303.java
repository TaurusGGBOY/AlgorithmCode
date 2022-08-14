import java.util.*;
import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] degree = new int[t + 1];
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Map<Integer, Character> colors = new HashMap<>();
        Map<Integer, Set<Character>> neighbor = new HashMap<>();
        char[] rgb = new char[]{'R', 'G', 'B'};
        while (t-- > 1) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            degree[a]++;
            degree[b]++;
            List<Integer> list1 = tree.getOrDefault(a, new ArrayList<>());
            list1.add(b);
            tree.put(a, list1);
            List<Integer> list2 = tree.getOrDefault(b, new ArrayList<>());
            list2.add(a);
            tree.put(b, list2);
        }
        int start = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colors.put(start, 'R');
        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = tree.get(poll);
            Set<Character> set = neighbor.getOrDefault(poll, new HashSet<>());
            neighbor.put(poll, set);
            set.add(colors.get(poll));

            for (int num : list) {
                if (colors.containsKey(num)) set.add(colors.get(num));
            }
            for (int num : list) {
                if (colors.containsKey(num)) continue;
                q.offer(num);
                if (set.size() == 3) colors.put(num, 'R');
                else {
                    for (int i = 0; i < rgb.length; i++) {
                        if (!set.contains(rgb[i])) {
                            colors.put(num, rgb[i]);
                            set.add(rgb[i]);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < degree.length; i++) {
            System.out.print(colors.get(i));
        }
        System.out.println();
    }
}
