import java.util.*;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] strs = s1.split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int[][] grid = new int[n][m];
        grid[0][0] = 1;
        String s = scanner.nextLine();
        int count = 1;
        Map<Character, int[]> map = new HashMap<>();
        map.put('W', new int[]{-1, 0});
        map.put('S', new int[]{1, 0});
        map.put('A', new int[]{0, -1});
        map.put('D', new int[]{0, 1});
        int[] pos = new int[]{0, 0};
        int i = 0;
        for (; i < s.length(); i++) {
            pos[0] += map.get(s.charAt(i))[0];
            pos[1] += map.get(s.charAt(i))[1];
            if (grid[pos[0]][pos[1]] == 0) {
                count++;
                grid[pos[0]][pos[1]] = 1;
                if(count == n * m) break;
            }
        }
        if (n * m == count) {
            System.out.println("Yes");
            System.out.println(i + 1);
        } else {
            System.out.println("No");
            System.out.println(n * m - count);
        }

    }
}
