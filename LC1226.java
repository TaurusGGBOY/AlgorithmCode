import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    Semaphore[] forks;
    Semaphore people;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
        people = new Semaphore(forks.length - 1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        people.acquire();
        forks[philosopher].acquire();
        forks[(philosopher + 1) % forks.length].acquire();
        people.release();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[philosopher].release();
        forks[(philosopher + 1) % forks.length].release();
    }
}