import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class Philosopher implements Runnable {
    private final int id;
    private int eatCount = 0;
    private Lock leftFork;
    private Lock rightFork;


    public Philosopher(int id) {
        this.id = id;
        this.leftFork = new ReentrantLock();
        this.rightFork = new ReentrantLock();
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is eating");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking");
    }

    private void takeForks() {
        leftFork.lock();
        rightFork.lock();
    }

    private void releaseForks() {
        leftFork.unlock();
        rightFork.unlock();
    }

    @Override
    public void run() {
        while (eatCount < DiningPhilosophers.NUM_EATING_CYCLES) {
            think();
            takeForks();
            eat();
            releaseForks();
            eatCount++;
        }
    }
}
