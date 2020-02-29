import java.util.Scanner;
import java.util.Vector;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Vector<Integer> vector = new Vector<>(21, 0);
        for (int i = 0; i < n; i++) {
            vector.add(scanner.nextInt());
        }
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++) {
                if (compare(vector.get(j), vector.get(j + 1)) == 0) {
                    int temp = vector.get(j);
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                }
            }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++)
            stringBuilder.append(String.valueOf(vector.get(i)));
        System.out.println(stringBuilder.toString());
    }

    static public int compare(int a, int b) {
        String aString = String.valueOf(a);
        String bString = String.valueOf(b);

        if (Integer.parseInt(aString + bString) > Integer.parseInt(bString + aString))
            return 1;
        else
            return 0;
    }
}
