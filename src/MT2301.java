import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        Queue<Integer> q = new PriorityQueue<>();
        while (n -- > 0){
            q.offer(scanner.nextInt());
        }
        int time = t;
        int res = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            if (time > poll) res++;
            else time += t;
        }
        System.out.println(res);
    }
}
