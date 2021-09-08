import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int[] visit = new int[tasks.length];
        int res = 0;
        int cap = sessionTime;
        for (int i = tasks.length - 1; i >= 0; i--) {
            if (visit[i] == 1) {
                continue;
            }
            if (cap >= tasks[i]) {
                cap -= tasks[i];
                visit[i] = 1;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (visit[j] == 1) {
                    continue;
                }
                if (cap >= tasks[j]) {
                    cap -= tasks[j];
                    visit[j] = 1;
                }
            }
//            System.out.println("res++ cap" + res + ";" + cap);
            res++;
            cap = sessionTime;
        }
//        System.out.println(Arrays.toString(visit));
//        System.out.println(res);
        if (cap != sessionTime) {
            res++;
        }
        return res;
    }
}