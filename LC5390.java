import java.util.Stack;
import java.util.Vector;

class Solution {
    String croak = "croak";

    public int minNumberOfFrogs(String croakOfFrogs) {
        StringBuilder stringBuilder = new StringBuilder(croakOfFrogs);
        int[] vector = new int[5];
        int maxNum = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {

            char c = stringBuilder.charAt(i);
            if (c == 'c') {
                vector[0]++;
                int temp = 0;
                for (int j = 0; j < vector.length - 1; j++) {
                    temp += vector[j];
                }
                maxNum = Math.max(maxNum, temp);
            } else {
//                System.out.println(c);
                if (vector[croak.indexOf(c) - 1] > 0) {
                    vector[croak.indexOf(c) - 1]--;
                    vector[croak.indexOf(c)]++;
                    if (croak.indexOf(c) == 4) {
                        vector[croak.indexOf(c)] = 0;
                    }
                } else {
//                  System.out.println("i"+i);
                  return -1;
                }
            }

        }

        int temp = 0;
        for (int j = 0; j < vector.length - 1; j++) {
            temp += vector[j];
        }
//        System.out.println(temp);
        return temp == 0 ? maxNum : -1;

    }


}