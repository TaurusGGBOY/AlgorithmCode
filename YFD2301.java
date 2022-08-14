import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while(t-- >0){
            String s = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            int[] alpha = new int[26];
            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i)-'a']++;
            }
            int res = 0;
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            for (String str1 : strs) {
                int[] alpha2 = new int[26];
                for (int i = 0; i < str1.length(); i++) {
                    alpha2[str1.charAt(i)-'a']++;
                }
                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < alpha.length; i++) {
                    if(alpha2[i]!=0) temp =  Math.min(alpha[i]/alpha2[i],temp);
                }
                res = Math.max(res, temp);
            }
            System.out.println(res);
        }
    }

}
