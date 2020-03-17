import java.util.concurrent.atomic.AtomicInteger;

// 失败
class Foo {

    AtomicInteger num = new AtomicInteger(0);
    public Foo() {
        switch (num)
        {
            case new AtomicInteger(0):
                first();
                break;

        }
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        num.incrementAndGet();
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        num.incrementAndGet();
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}