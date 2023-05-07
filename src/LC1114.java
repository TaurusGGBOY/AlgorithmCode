import java.util.concurrent.Semaphore;

class Foo {
    Semaphore[] semaphore = new Semaphore[3];

    public Foo() {
        semaphore[0] = new Semaphore(1);
        semaphore[1] = new Semaphore(0);
        semaphore[2] = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphore[0].acquire();
        printFirst.run();
        semaphore[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore[1].acquire();
        printSecond.run();
        semaphore[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore[2].acquire();
        printThird.run();
        semaphore[0].release();
    }
}