/*
Есть пять философов (потоки), которые могут либо обедать либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд
 */
public class DiningPhilosophers {
    public static final int NUM_EATING_CYCLES = 3 ;
    private static final int NUM_PHILOSOPHERS = 5;

    private static Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
    private static Object[] forks = new Object[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i);
            new Thread(philosophers[i]).start();
        }
    }
}

