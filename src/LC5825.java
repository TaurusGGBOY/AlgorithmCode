import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int res;
    int max;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        res = 0;
        max = 0;
        Map<Integer, String> sMap = new HashMap<>();
        Map<Integer, String> mMap = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < students[i].length; j++) {
                stringBuilder.append(students[i][j]);
            }
            sMap.put(i, stringBuilder.toString());
        }

        for (int i = 0; i < mentors.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < mentors[i].length; j++) {
                stringBuilder.append(mentors[i][j]);
            }
            mMap.put(i, stringBuilder.toString());
        }

        int[][] score = new int[students.length][mentors.length];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                score[i][j] = students[0].length - Integer.bitCount(Integer.parseInt(sMap.get(i), 2) ^ Integer.parseInt(mMap.get(j), 2));
            }
//            System.out.println(Arrays.toString(score[i]));
        }
        int[] stu = new int[students.length];
        int[] men = new int[mentors.length];
        for (int j = 0; j < score.length; j++) {
            for (int k = 0; k < score[0].length; k++) {
                stu[j] = 1;
                men[k] = 1;
                res += score[j][k];
                back(score, stu, men, 1);
                res -= score[j][k];
                stu[j] = 0;
                men[k] = 0;
            }
        }

        return max;
    }

    void back(int[][] score, int[] stu, int[] men, int depth) {
        if (depth >= stu.length) {
            max = Math.max(res, max);
//            System.out.println(max);
            return;
        }
        int maxS = 0;
        for (int j = 0; j < score.length; j++) {
            for (int k = 0; k < score[0].length; k++) {
                if (stu[j] == 1) {
                    break;
                }
                if (men[k] == 1) {
                    continue;
                }
                if (score[j][k] > maxS) {
                    maxS = score[j][k];
                }
            }
        }

        for (int j = 0; j < score.length; j++) {
            for (int k = 0; k < score[0].length; k++) {
                if (stu[j] == 1) {
                    break;
                }
                if (men[k] == 1) {
                    continue;
                }
                if (score[j][k] == maxS) {
                    stu[j] = 1;
                    men[k] = 1;
                    res += maxS;
                    back(score, stu, men, depth + 1);
                    res -= maxS;
                    stu[j] = 0;
                    men[k] = 0;
                }
            }
        }
    }
}