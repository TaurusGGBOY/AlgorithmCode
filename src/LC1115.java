import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
        stateFoo = new Semaphore(1);
        stateBar = new Semaphore(0);
    }

    Semaphore stateFoo;
    Semaphore stateBar;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            stateFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            stateBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            stateBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            stateFoo.release();
        }
    }
}