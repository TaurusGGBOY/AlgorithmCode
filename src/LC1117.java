import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {
    Semaphore[] semaphores;
    CyclicBarrier cyclicBarrier;

    public H2O() {
        semaphores = new Semaphore[]{new Semaphore(2), new Semaphore(1)};
        cyclicBarrier = new CyclicBarrier(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphores[0].acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphores[0].release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphores[1].acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphores[1].release();

    }
}