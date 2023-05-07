
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int flag = 1;
        Vector<Integer> vector = new Vector<>();
        Vector<Integer> flagVec = new Vector<>();
        for (int i = 0; i < n; i++) {
            vector.add(scanner.nextInt());
            flagVec.add(0);
        }
        int scores = 0;
        int count = 1;
        int start = 0;
        int end = 0;
        int maxCount = 0;
        int lastNum = vector.get(0);
        while (flag == 1) {
            System.out.println(vector.toString());
            System.out.println(flagVec.toString());
            flag = 0;
            int startPos = 0;
            for (int i = 0; i < n; i++) {
                if (flagVec.get(i) == 0) {
                    startPos = i;
                    break;
                }
            }
            if (startPos == n - 1)
                break;
            start = startPos;
            lastNum = vector.get(startPos);
            for (int i = startPos + 1; i < n; i++) {
                if (flagVec.get(i) == 0) {
                    if (vector.get(i) == lastNum) {
                        count++;
                        if (count > maxCount) {
                            maxCount = count;
                            end = i;
                        }
                        flag = 1;
                    } else {
                        start = i;
                        count = 1;
                        lastNum = flagVec.get(i);
                    }

                }
            }
            for (int i = start; i <= end; i++) {
                flagVec.set(i, -1);
            }
            scores += count * count;
            count = 1;
            start = 0;
            end = 0;
            maxCount = 0;

        }
        System.out.println(scores);
    }
}