import java.util.Scanner;

public class Main {
	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = n / 2; i > 1; i++)
			if (isZhi(i) && isZhi(n - i)) {
				System.out.println(i * (n - i));
				break;
			}
	}

	static boolean isZhi(int a) {
		if (a == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}
}
