import java.util.concurrent.Semaphore;

class Foo {
    Semaphore[] semaphores = new Semaphore[2];

    public Foo() {
        semaphores[0] = new Semaphore(0);
        semaphores[1] = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphores[0].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphores[0].acquire();
        printSecond.run();
        semaphores[1].release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        semaphores[1].acquire();
        printThird.run();
    }
}