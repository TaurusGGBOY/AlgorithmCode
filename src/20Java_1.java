import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count =0;
        for(int i =1;i<=n;i++)
        {
            int temp = (int)Math.pow(i,3);
            int squr = (int)Math.sqrt(temp);
            count+= temp==squr*squr?1:0;
        }
        System.out.println(count);
    }
}