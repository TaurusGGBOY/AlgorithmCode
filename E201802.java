import java.util.Scanner;

public class Main {

	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1 2 4 7 11 16 22
		// 0001 0010 0100 0111 1011
		// n*n+n+0.25=2*a+0.25
		// n+0.5=sqrt(2*a+0.25)
		// n=sqrt(2*a+0.25)-0.25
		int t = scanner.nextInt();
		int n;
		int a;
		for (int i = 0; i < t; i++) {
			a = scanner.nextInt() - 1;
			n = (int) (Math.sqrt(2 * a + 0.25) - 0.5);
			if (n * n + n == 2 * a)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
