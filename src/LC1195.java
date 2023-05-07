import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    Semaphore[] semaphores;

    public FizzBuzz(int n) {
        this.n = n;
        semaphores = new Semaphore[4];
        semaphores[0] = new Semaphore(0);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
        semaphores[3] = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            semaphores[0].acquire();
            if (i % 15 == 0) {
                continue;
            }
            printFizz.run();
            semaphores[3].release();
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            semaphores[1].acquire();
            if (i % 15 == 0) {
                continue;
            }
            printBuzz.run();
            semaphores[3].release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            semaphores[2].acquire();
            printFizzBuzz.run();
            semaphores[3].release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphores[3].acquire();
            if (i % 15 == 0) {
                semaphores[0].release();
                semaphores[1].release();
                semaphores[2].release();
            } else if (i % 3 == 0) semaphores[0].release();
            else if (i % 5 == 0) semaphores[1].release();
            else {
                printNumber.accept(i);
                semaphores[3].release();
            }
        }
    }
}