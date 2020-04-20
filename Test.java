import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) {
        BigInteger res = new BigInteger("1");

        long startTime = System.currentTimeMillis();
        System.out.println("执行代码块/方法");

        for (int i = 1; i <= 1000; i++) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(res);

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
