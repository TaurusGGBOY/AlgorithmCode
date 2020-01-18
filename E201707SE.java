import java.util.Scanner;

public class E201707SE {
	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int symbol = 0;
		double num = scanner.nextDouble();
		if (num < 0)
			symbol = 1;
		else
			symbol = 0;

		double di = Math.abs(num);
		int jie = 0;
		while (di < 0.5 || di >= 1)
			if (di < 0.5) {
				di = di * 2;
				jie--;
			} else if (di >= 1) {
				di = di / 2;
				jie++;
			}
		StringBuilder diStringBuilder = new StringBuilder();
		for (int i = 0; i < 52; i++) {
			if (di * 2 >= 1) {
				di = di * 2 - 1;
				diStringBuilder.append("1");
			} else {
				di = di * 2;
				diStringBuilder.append("0");
			}
		}

		StringBuilder jieStringbuilder = new StringBuilder();
		String jieStr = Integer.toBinaryString(jie + 1023);
		for (int i = 0; i < 11 - jieStr.length(); i++)
			jieStringbuilder.append("0");
		jieStringbuilder.append(jieStr);

		StringBuilder allString = new StringBuilder();
		allString.append(String.valueOf(symbol));
		allString.append(jieStringbuilder.toString());
		allString.append(diStringBuilder.toString());

		System.out.println(allString);

		StringBuilder lasthex = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			lasthex.append(Integer.toHexString(Integer.valueOf(allString.toString().substring(i * 4, i * 4 + 4), 2)));
		}
		System.out.println(lasthex);
		char[] lasthexchar = lasthex.toString().toCharArray();

		StringBuilder lastHexHappen = new StringBuilder();
		for (int i = 0; i < lasthex.toString().length() / 2; i++) {
			lastHexHappen.append(lasthexchar[i]);
			lastHexHappen.append(lasthexchar[i + 1]);
			lastHexHappen.append("-");
		}
		System.out.println(lastHexHappen.substring(0, lastHexHappen.length() - 1).toString().toUpperCase());
	}
	// ¾ØÐÎ¸²¸ÇÃæ»ý

}
