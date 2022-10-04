import java.util.*;

public class Main {
    static Set<Character> set = new HashSet<>();
    static int[] alpha = new int[26];


    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s, i)) res++;
        }
        System.out.println(res);
    }

    static boolean isValid(String s, int pos) {
        if (pos + 4 >= s.length()) return false;
        Arrays.fill(alpha, 0);
        for (int i = 0; i < 5; i++) {
            int num = s.charAt(pos + i) - 'a';
            alpha[num]++;
            if (alpha[num] > 1) return false;
        }
        if (set.contains(s.charAt(pos))) return false;
        if (!set.contains(s.charAt(pos + 1))) return false;
        if (!set.contains(s.charAt(pos + 2))) return false;
        if (set.contains(s.charAt(pos + 3))) return false;
        if (!set.contains(s.charAt(pos + 4))) return false;
        return true;
    }
}
