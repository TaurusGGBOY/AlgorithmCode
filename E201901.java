import java.util.Scanner;

public class Main {

	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			int pos = 0;
			for (int j = 0; j < k; j++) {
				pos = (pos + m) % n;
				System.out.println(pos + 1);
			}

		}
	}
}
