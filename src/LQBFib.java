import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<=2){
            System.out.println(1);
            return;
        }
        long f1=1;
        long f2=1;
        for (int i = 3; i <= n; i++) {
            long temp = f2;
            f2=(f2+f1)%10007;
            f1=f2;
        }
        System.out.println(f1);
    }
}