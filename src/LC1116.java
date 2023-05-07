import java.util.Arrays;
import java.util.concurrent.Semaphore;

class ZeroEvenOdd {
    private int n;
    Semaphore[] semaphores;

    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphores = new Semaphore[]{new Semaphore(0), new Semaphore(0), new Semaphore(1)};
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphores[2].acquire();
            printNumber.accept(0);
            semaphores[i % 2].release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphores[0].acquire();
            printNumber.accept(i);
            semaphores[2].release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphores[1].acquire();
            printNumber.accept(i);
            semaphores[2].release();
        }
    }
}