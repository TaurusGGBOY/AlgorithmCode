import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int totalk = 0;
		int maxk = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			maxk = 0;
			for (int j = 0; j < m; j++) {
				k = scanner.nextInt();
				if (k > maxk)
					maxk = k;
			}
			totalk += maxk;
		}
		System.out.println(totalk);
	}
}
