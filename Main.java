//import java.util.*;
//
//// 100 80 200 150
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        double[] arr = new[n];
//
//        double[] dis = new[n - 1];
//
//        for (int i = 0; i < n ; i++) {
//            arr[i] = scanner.nextDouble();
//        }
//        Arrays.sort(arr);
//        for (int i = 0; i < n - 1; i++) {
//            dis[i] = arr[i + 1] - arr[i];
//        }
//
//        int minHeightDis = 0;
//        int Weight = 0;
//        for (int i = 0; i < m - 1; i++) {
//            Weight += arr[i];
//            minHeightDis += dis[i];
//        }
//        Weight += arr[m - 1];
//        int maxWeight = Weight;
//        for (int i = m - 1; i < n - 1; i++) {
//
//        }
//        System.out.println();
//    }
//}
import java.util.*;

public class Main {
    static int max(int max,int min){
        return max>min?max:min;
    }
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n ; i++) {
            a[i] = scanner.nextDouble();
        }
        Arrays.sort(a);
        double ma = 0;
        double cha = Integer.MAX_VALUE;
        for(int i = 0;i<n-m;i++){
            double tmp_ma = a[i] + a[i+1] + a[i+2] + a[i+3];
            double tmp_cha = a[i+3]-a[i];
            if(tmp_cha <= cha)
            {
                cha = tmp_cha;
                ma = tmp_ma;
            }
        }
        System.out.printf("%.2f\n",ma);
        Set<>
    }
}

// 8 4 11 9 12 5 10 19 8 6